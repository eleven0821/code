package com.zs.pms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.DateUtil;
import com.zs.pms.vo.QueryUser;

@Controller // 声明控制器
public class LoginController {
	@Autowired
	UserService us;// 注入用户业务层对象

	// 页面跳转到tologin.do
	@RequestMapping("/tologin.do")
	public String toLogin() {
		return "login";
	}

	// 新增，返回类型为String的方法，调用DispatcherServlet的getDispatcher(url)转发方法
	@RequestMapping("/login.do") // 匹配jsp页面表单转发URL，匹配成功则执行相应的方法
	public String login(QueryUser query, String code, ModelMap model, HttpSession session) {

		// 获取图片中的验证码
		String ocode = (String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		// 判断验证码是否匹配
		if (!ocode.equals(code)) {
			// 验证码错误信息回带到页面
			model.addAttribute("验证码输入有误，请重新输入");
			// 返回登录页面
			return "login";
		}

		try {
			// 调用业务层验证登录方法
			TUser user = us.chkLogin(query);
			// 用户信息存放到session对象作用域中
			session.setAttribute("CUSER", user);
			// 服务器当前日期存放到session对象作用域中
			session.setAttribute("TODAY", DateUtil.getStrDate(new Date()));
			// 登录成功，跳转到主页面
			return "main";
			
			// 业务异常
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// 业务异常信息回带到页面
			model.addAttribute("MSG", e.getErrMsg());
			// 业务异常，跳转到登录页面
			return "login";

			// 系统异常
		} catch (Exception e1) {
			e1.printStackTrace();
			// 系统异常，跳转到错误页面
			return "error";
		}

	}

	// 跳转totop.do
	@RequestMapping("/totop.do")
	public String toTop() {
		// 返回到top页面
		return "top";
	}

	// 跳转toleft.do
	@RequestMapping("/toleft.do")
	public String toLeft() {
		// 返回到left页面
		return "left";
	}

	// 跳转toright.do
	@RequestMapping("/toright.do")
	public String toRight() {
		// 返回到right页面
		return "right";
	}

}
