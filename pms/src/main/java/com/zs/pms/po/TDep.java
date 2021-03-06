package com.zs.pms.po;

import java.io.Serializable;

/*
 * 部门表
 * */
public class TDep implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6693929339309480899L;

	private int id;// 部门id
	private String name;// 部门名称
	private int pid;// 上级部门id

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

}
