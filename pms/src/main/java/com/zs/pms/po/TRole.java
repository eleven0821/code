package com.zs.pms.po;

import java.io.Serializable;

/*
 * 角色表
 * */
public class TRole implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1962827445200282876L;

	private int id;// 角色id
	private String rname;// 角色名

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

}
