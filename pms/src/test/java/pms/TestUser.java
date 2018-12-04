package pms;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zs.pms.dao.UserDao2;
import com.zs.pms.exception.AppException;
import com.zs.pms.po.TDep;
import com.zs.pms.po.TPermission;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.MD5;
import com.zs.pms.vo.QueryUser;

@RunWith(SpringJUnit4ClassRunner.class) // 使用spring测试框架
@ContextConfiguration("classpath:applicationcontext.xml") // 引入配置文件
public class TestUser {
	@Autowired // 注入
	UserService us;
	
	// 判断登录是否成功
	public void testLogin() {
		// 创建对象
		QueryUser query = new QueryUser();
		// 存入用户登录信息
		query.setLoginname("test1");
		query.setPassword("test1");// 输入明码
		try {
			// 判断用户登录是否成功
			TUser user = us.chkLogin(query);
			System.out.println(user.getRealname() + "、" + user.getDept().getName());
			// 遍历用户的权限列表信息，并输出用户的权限名称
			for (TPermission per : user.getPermissions()) {
				System.out.println(per.getPname());
			}

			System.out.println("-----------------整理后-----------------");
			// 遍历权限集合，获取一级权限
			for (TPermission per1 : user.getMenu()) {
				// 输出一级权限名
				System.out.println(per1.getPname());
				// 遍历权限集合，获取二级权限
				for (TPermission per2 : per1.getChildren()) {
					// 输出二级权限名
					System.out.println("\t" + per2.getPname());
				}
			}

		} catch (AppException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getErrMsg());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void testQuery() {
		// 创建对象
		QueryUser query = new QueryUser();
		// 存入用户登录信息
		query.setLoginname("test1");
		query.setPassword("5A105E8B9D40E1329780D62EA2265D8A");
		//query.setIsenabled(1);
		us.queryByCon(query);
		
	}

	
	// 批量删除
	public void testDelete() {
		// 定义数组
		int[] ids = { 3088, 3089, 3096 };
		try {
			us.deleteByIds(ids);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//修改
	public void testUpdate() {
		//创建对象
		TUser user=new TUser();
		//修改属性
		user.setId(3099);
		//user.setPassword("1111");
		user.setSex("女");
		//user.setBirthday(new Date());
		//user.setEmail("asd@123.com");
		
		//创建部门对象
		TDep dept=new TDep();
		dept.setId(8);
		//user.setDept(dept);
		
		//user.setRealname("张三");
		//user.setUpdator(1001);
		//user.setPic("qwe.jsp");
		user.setIsenabled(-1);
		
		try {
			us.update(user);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void testAdd(){
		//创建对象
		TUser user=new TUser();
		user.setLoginname("lisi");
		user.setPassword("1234");
		user.setSex("男");
		user.setBirthday(new Date());
		user.setEmail("asd@123.com");
				
		//创建部门对象
		TDep dept=new TDep();
		dept.setId(8);
		user.setDept(dept);
				
		user.setRealname("李四");
		user.setCreator(1000);
		user.setPic("qwe.jsp");
		
		try {
			us.insert(user);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	//删除一条
	
	public void testDeleteById(){
		
		try {
			us.delete(1007);
		} catch (AppException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//查询总页数
	@Test // 引入junit
	public void testPage(){
		QueryUser query=new QueryUser();
		query.setSex("男");
		System.out.println("总页数："+us.queryPageCount(query));
		for(TUser user:us.queryByPage(query, 2)){
			System.out.println(user.getRealname());
		}
		
	}

}
