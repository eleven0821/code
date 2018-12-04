package com.zs.pms.service;

import java.util.List;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TUser;
import com.zs.pms.vo.QueryUser;

public interface UserService {
	//判断用户登录
	public TUser chkLogin(QueryUser query) throws AppException;
	//根据条件查询用户
	public List<TUser> queryByCon(QueryUser query);
	//批量删除
	public void deleteByIds(int[] ids)  throws AppException;
	//修改，需要抛出异常
	public void update(TUser user) throws AppException;
	//新增
	public int insert(TUser user) throws AppException;
	//删除一条
	public void delete(int id) throws AppException;
	//查询一条
	public TUser queryById(int id);
	//分页查询，当前页传入方法中
	public List<TUser> queryByPage(QueryUser query,int page);
	//获得总页数
	public int queryPageCount(QueryUser query);
}
