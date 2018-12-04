package com.zs.pms.po;

import java.io.Serializable;
import java.util.Date;

/*
 * 文章表，持久层对象persistent object
 * */
public class TArticle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 379814413321609472L;

	private int id;//文章id
	private String title;//文章标题
	private String content;//文章内容
	private String author;//文章作者
	private int creator;//文章创建人
	private Date crtime;//文章创建时间
	private TChannel channel;//文章所属栏目
	private int isremod;//是否推荐
	private int ishot;//是否热点
	private int updater;//文章修改人
	private Date updatime;//文章修改时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	public Date getCrtime() {
		return crtime;
	}
	public void setCrtime(Date crtime) {
		this.crtime = crtime;
	}
	public TChannel getChannel() {
		return channel;
	}
	public void setChannel(TChannel channel) {
		this.channel = channel;
	}
	public int getIsremod() {
		return isremod;
	}
	public void setIsremod(int isremod) {
		this.isremod = isremod;
	}
	public int getIshot() {
		return ishot;
	}
	public void setIshot(int ishot) {
		this.ishot = ishot;
	}
	public int getUpdater() {
		return updater;
	}
	public void setUpdater(int updater) {
		this.updater = updater;
	}
	public Date getUpdatime() {
		return updatime;
	}
	public void setUpdatime(Date updatime) {
		this.updatime = updatime;
	}
	
	
	
}
