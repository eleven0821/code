package com.zs.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.zs.pms.dao.ChannelDao;
import com.zs.pms.po.TChannel;

//栏目业务接口
public interface ChannelService {
	//根据栏目id查询栏目
	public List<TChannel> queryById(int id);
}
