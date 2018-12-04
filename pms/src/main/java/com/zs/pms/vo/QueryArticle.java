package com.zs.pms.vo;


/*
 * 文章查询可视化对象visual object
 * */
public class QueryArticle extends QueryPage {
	private String title;//文章标题
	private String author;//文章作者
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
