package com.zs.pms.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TDep;
import com.zs.pms.po.TUser;
import com.zs.pms.service.DepService;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.QueryUser;

/*
 * 用户控制层
 * */
@Controller // 声明控制层
public class UserController {
	@Autowired
	UserService us;// 注入用户业务层对象

	@Autowired
	DepService ds;// 注入部门业务服务对象

	//查询用户
	@RequestMapping("/user/list.do") // 二级url
	public String list(QueryUser query, String page, ModelMap map) {
		// 判断当前页是否为空
		if (page == null || "".equals(page)) {
			// 如果空，当前页数为1，即当前为第一页
			page = "1";
		}
		
		// 调用用户业务层对象的分页查询方法，将分页查询的用户信息回带到页面
		map.addAttribute("LIST", us.queryByPage(query, Integer.parseInt(page)));
		// 将当前页数回带到页面，用于分页查询
		map.addAttribute("PAGE", page);
		// 调用用户业务层对象的查询总页数方法，将查询的总页数回带到页面，用于分页查询
		map.addAttribute("PAGECOUNT", us.queryPageCount(query));
		// 将用户数据回带到页面
		map.addAttribute("QUERY", query);
		// 返回user/list.jsp页面
		return "user/list";
	}

	//新增用户跳转到新增页面
	@RequestMapping("/user/toadd.do")
	public String toAdd(ModelMap map) {

		// 获取一级部门信息
		List<TDep> dep1 = ds.queryByPid(0);
		// 将一级部门信息回带到页面
		map.addAttribute("DEP1", dep1);
		// 获取默认一级部门下的二级部门信息
		List<TDep> dep2 = ds.queryByPid(dep1.get(0).getId());
		// 将默认一级部门下的二级部门回带到页面
		map.addAttribute("DEP2", dep2);
		//返回到add.jsp页面
		return "user/add";
	}
	

	
	//新增用户
	@RequestMapping("/user/add.do")
	public String add(TUser user,ModelMap map,HttpSession session){
		try { 
			//从session作用域中获取登录用户信息
			TUser user2=(TUser)session.getAttribute("CUSER");
			user.setCreator(user2.getId());//创建人
			user.setIsenabled(1);//可用
			//user.setPic("");//图片路径
			//调用用户业务对象的新增方法
			us.insert(user);
			//重定向跳转到指定url，将新增后的所有用户数据回带到list.jsp页面上，所以必须重新执行list.do，新增不需要传参
			return "redirect:list.do";
		} catch (AppException e) {
			// TODO Auto-generated catch block
			//错误信息回带到页面
			map.addAttribute("MSG", e.getErrMsg());
			//新增失败后，重新跳转到新增页面，并将已经添加的部门信息和错误提示信息回带到新增页面
			return this.toAdd(map);
		}
	}
	
	
	/*
	 * 获取二级部门信息
	 * 以ajax方式响应 
	 * 如果方法返回类型String，ajax返回数据类型为文本text格式
	 * 如果方法返回类型为对象，ajax返回数据类型为json格式
	 * SpringMVC自动将对象数据转成json类型数据，
	 * 调用JSONArray的fromObject(对象名)，通过响应的getWriter()获取写入对象，write()写入
	 * */
	@RequestMapping("/user/getdep.do")
	@ResponseBody //以ajax方式异步响应，返回内容（文本text格式或对象json格式）
	public List<TDep> getDept(int pid){
		List<TDep> list=ds.queryByPid(pid);
		return list;
		
	}
	
	//删除一条
	@RequestMapping("/user/delete.do")
	public String delete(int id){
		try {
			us.delete(id);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//重定向到用户列表页面
		return "redirect:list.do";
	}
	
	//删除多条，批量删除
	@RequestMapping("/user/deletes.do")
	public String deletes(int[] ids){
		try {
			us.deleteByIds(ids);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//重定向到用户列表页面
		return "redirect:list.do";
	}
	
	
	//修改用户
	@RequestMapping("/user/get.do")
	public String get(int id,ModelMap map){
		TUser user=us.queryById(id);
		map.addAttribute("USER", user);
		List<TDep> dep1=ds.queryByPid(0);
		map.addAttribute("DEP1", dep1);
		List<TDep> dep2=ds.queryByPid(user.getDept().getPid());
		map.addAttribute("DEP2", dep2);
		return "user/update";
		
	}
	
	//修改用户
	@RequestMapping("/user/update.do")
	public String update(TUser user,HttpSession session,ModelMap map){
		//从session作用域中获取用户信息
		TUser cuser=(TUser)session.getAttribute("CUSER");
		//登录人就是修改人
		user.setUpdator(cuser.getId());
		try {
			us.update(user);
			//修改成功后，重新跳转到list.do，刷新页面
			return"redirect:list.do";
		} catch (AppException e) {
			// TODO Auto-generated catch block
			//修改失败，将错误信息回带到页面
			map.addAttribute("MSG", e.getErrMsg());
			//修改失败，跳转到get.do，将已填写的信息回带到页面，刷新修改页面
			return get(user.getId(), map);
		}
		
	}
	
	
}
