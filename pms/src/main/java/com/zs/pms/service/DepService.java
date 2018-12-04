package com.zs.pms.service;

import java.util.List;

import com.zs.pms.po.TDep;

/*
 * 部门业务接口
 * */
public interface DepService {
	//根据部门上级id获取一级部门
	public List<TDep> queryByPid(int id);
}
