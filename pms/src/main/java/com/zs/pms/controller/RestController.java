package com.zs.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zs.pms.po.TUser;
import com.zs.pms.service.UserService;

@Controller //声明控制器
public class RestController {
	@Autowired
	UserService us;//Spring注入
	
	//获取指定用户信息
	//自定义url路径userinfo/{id}.do，大括号中id是占位
	@RequestMapping(value="/userinfo/{id}.do") 
	@ResponseBody //ajax的json格式返回数据
	public TUser queryById(@PathVariable("id") int id){ //小括号中的id就是requestmapping设置的占位id
		return us.queryById(id);
	}
}
