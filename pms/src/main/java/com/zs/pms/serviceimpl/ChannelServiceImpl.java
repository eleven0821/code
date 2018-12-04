package com.zs.pms.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zs.pms.dao.ChannelDao;
import com.zs.pms.po.TChannel;
import com.zs.pms.service.ChannelService;

@Service //栏目业务实现
public class ChannelServiceImpl implements ChannelService {
	@Autowired
	ChannelDao cdao;//注入栏目dao对象

	@Override
	public List<TChannel> queryById(int id) {
		// TODO Auto-generated method stub
		return cdao.queryById(id);
	}

}
