package com.zs.pms.vo;

/*
 * 用户查询可视化对象visual object
 * */
public class QueryUser extends QueryPage {
	private String loginname;// 登录名
	private String password;// 登录密码
	private int isenabled;// 是否可用
	private String sex;//性别
	
	

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public int getIsenabled() {
		return isenabled;
	}

	public void setIsenabled(int isenabled) {
		this.isenabled = isenabled;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
