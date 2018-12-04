package com.zs.pms.vo;

import com.zs.pms.utils.Constants;

//分页对象
public class QueryPage {
	protected int start;//起始行数
	protected int end;//截止行数
	protected int page;//当前页数
	
	//获得起始行数
	public int getStart() {
		//起始行数start=(当前页数-1)*每页行数-1
		return (page-1)*Constants.PAGECOUNT+1;
	}
	public void setStart(int start) {
		this.start = start;
	}
	//获得截止行数
	public int getEnd() {
		//截止行数end=当前页数*每页行数
		return page*Constants.PAGECOUNT;
	}
	public void setEnd(int end) {
		this.end = end;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
}
