package com.zs.pms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zs.pms.dao.UserDao;
import com.zs.pms.dao.UserDao2;
import com.zs.pms.exception.AppException;
import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;
import com.zs.pms.utils.Constants;
import com.zs.pms.utils.MD5;
import com.zs.pms.vo.QueryUser;

@Service //用户对象实现
@Transactional //用户业务支持事务
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao udao;//注入用户dao对象

	public TUser chkLogin(QueryUser query) throws AppException {
		// TODO Auto-generated method stub
		
		//将明码 变成密码
		MD5 md5=new MD5();
		//加密后的密码
		String p1=md5.getMD5ofStr(query.getPassword());
		//将密码存放query中
		query.setPassword(p1);
		
		//查询用户信息
		List<TUser> list=udao.queryByCon(query);
		//判断是否有用户信息，如果没有，则抛出自定义异常
		if(list==null||list.size()!=1){
			throw new AppException(1000, "用户名或密码输入错误，请重新输入");
		}
		//数据库有用户信息，返回集合第一条，即用户信息
		TUser user=list.get(0);
		
		//通过用户id获取用户信息，关联查询
		return udao.queryById(user.getId());
	}

	@Override
	public List<TUser> queryByCon(QueryUser query) {
		// TODO Auto-generated method stub
		return udao.queryByCon(query);
	}

	@Override
	@Transactional(rollbackFor=Exception.class) //有异常就回滚，无异常就提交
	public void deleteByIds(int[] ids) {
		// TODO Auto-generated method stub
		udao.deleteByIds(ids);
		
	}

	@Override
	@Transactional(rollbackFor=Exception.class) //有异常就回滚，无异常就提交
	public void update(TUser user) throws AppException {
		// TODO Auto-generated method stub
		//判断是否不可用，不可用的用户不能修改
		if(user.getIsenabled()==-1){
			//用户不可用时，抛出异常
			throw new AppException(1003, "用户不可用，不能修改");
		}
		
		//获取原来的用户信息，用于判断修改前用户密码是否等于修改后密码
		TUser ouser=udao.queryById(user.getId());
		
		//判断密码是否为空，密码不为空，并且不为空字符串，并且修改前密码不等于修改后密码，才加密
		if(user.getPassword()!=null&&(!"".equals(user.getPassword()))&&!user.getPassword().equals(ouser.getPassword())){
			//创建MD5对象，用于密码加密
			MD5 md5=new MD5();
			//将输入的密码进行md5加密
			user.setPassword(md5.getMD5ofStr(user.getPassword()));
		}
		//调用用户dao的修改方法
		udao.update(user);
	}
	
	//新增
	@Override
	@Transactional(rollbackFor=Exception.class) //有异常就回滚，无异常就提交
	public int insert(TUser user) throws AppException {
		// TODO Auto-generated method stub
		//创建MD5对象，用于密码加密
		MD5 md5=new MD5();
		//将输入的密码进行md5加密
		user.setPassword(md5.getMD5ofStr(user.getPassword()));
		return udao.insert(user);
	}
	
	//删除一条
	@Override
	@Transactional(rollbackFor=Exception.class) //有异常就回滚，无异常就提交
	public void delete(int id) throws AppException {
		// TODO Auto-generated method stub
		udao.delete(id);
	}
	
	//查询一条
	@Override
	public TUser queryById(int id) {
		// TODO Auto-generated method stub
		return udao.queryById(id);
	}

	//分页查询
	@Override
	public List<TUser> queryByPage(QueryUser query,int page) {
		// TODO Auto-generated method stub
		//将当前页设置到条件中，可以设置起始和截止行数
		query.setPage(page);
		
		return udao.queryByPage(query);
	}

	//查询总页数
	@Override
	public int queryPageCount(QueryUser query) {
		// TODO Auto-generated method stub
		//获取总行数
		int count=udao.queryCount(query);
		//判断总条数/每页条数，是否能整除
		if(count%Constants.PAGECOUNT==0){
			//能整除，返回总页数
			return count/Constants.PAGECOUNT;
		}else{
			//不能整除
			return count/Constants.PAGECOUNT+1;
		}
		
	}

	
	
	
}
