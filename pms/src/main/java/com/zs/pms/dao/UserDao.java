package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.TUser;
import com.zs.pms.vo.QueryUser;

/*
 * 用户表接口，操作数据库中用户表数据
 * */
public interface UserDao {
	// 通过条件查询用户
	public List<TUser> queryByCon(QueryUser query);

	// 分页查询
	public List<TUser> queryByPage(QueryUser query);

	// 根据用户id获取用户信息
	public TUser queryById(int id);

	// 批量删除
	public void deleteByIds(int[] ids);

	// 新增
	public int insert(TUser user);

	// 修改
	public void update(TUser user);

	// 删除
	public void delete(int id);

	// 查询总条数，用于分页查询
	public int queryCount(QueryUser query);
	

}
