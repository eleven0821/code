package com.zs.pms.po;

import java.io.Serializable;
import java.util.Date;

public class TSku implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3127484416070583435L;
	
	private int id;
	private int pid;//商品id
	private String color;//颜色
	private int psize;//商品尺寸
	private String feature;//商品材质
	private double trancost;//运费
	private double sellcost;//售价
	private int recont;//库存数
	private int limit;//购买限制
	private String wpos;//仓库号
	private String skupic;//SKU图片
	private String skuname;//SKU名称
	private double price;//市场价格
	private double sellcont;//销量
	private int creator;//新增人
	private Date creatime;//新增时间
	private int updator;//修改人
	private Date updatime;//修改时间
	private int safcont;//安全库存
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPsize() {
		return psize;
	}
	public void setPsize(int psize) {
		this.psize = psize;
	}
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feature) {
		this.feature = feature;
	}
	public double getTrancost() {
		return trancost;
	}
	public void setTrancost(double trancost) {
		this.trancost = trancost;
	}
	public double getSellcost() {
		return sellcost;
	}
	public void setSellcost(double sellcost) {
		this.sellcost = sellcost;
	}
	public int getRecont() {
		return recont;
	}
	public void setRecont(int recont) {
		this.recont = recont;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
	public String getWpos() {
		return wpos;
	}
	public void setWpos(String wpos) {
		this.wpos = wpos;
	}
	public String getSkupic() {
		return skupic;
	}
	public void setSkupic(String skupic) {
		this.skupic = skupic;
	}
	public String getSkuname() {
		return skuname;
	}
	public void setSkuname(String skuname) {
		this.skuname = skuname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getSellcont() {
		return sellcont;
	}
	public void setSellcont(double sellcont) {
		this.sellcont = sellcont;
	}
	public int getCreator() {
		return creator;
	}
	public void setCreator(int creator) {
		this.creator = creator;
	}
	public Date getCreatime() {
		return creatime;
	}
	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	public int getUpdator() {
		return updator;
	}
	public void setUpdator(int updator) {
		this.updator = updator;
	}
	public Date getUpdatime() {
		return updatime;
	}
	public void setUpdatime(Date updatime) {
		this.updatime = updatime;
	}
	public int getSafcont() {
		return safcont;
	}
	public void setSafcont(int safcont) {
		this.safcont = safcont;
	}
	
	

}
