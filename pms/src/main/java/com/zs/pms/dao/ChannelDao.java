package com.zs.pms.dao;

import java.util.List;

import com.zs.pms.po.TChannel;

/*
 * 操作数据库栏目表
 * */
public interface ChannelDao {
	//根据栏目id获取栏目信息
	public List<TChannel> queryById(int id);
}
