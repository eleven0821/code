package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.TDep;

/*
 * 操作部门表数据
 * */
public interface DepDao {
	//根据部门上级id获取二级部门，用于显示二级部门（部门都有上级id，所以根据上级部门id查询部门信息）
	public List<TDep> queryByPid(int pid);
}
