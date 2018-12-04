package com.zs.pms.po;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.zs.pms.utils.DateUtil;

/*
 * 用户表，持久层对象persistent object
 * */
public class TUser implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5293214558214995122L;

	private int id;// 用户id
	private String loginname;// 登录名，不修改
	private String password;// 用户密码
	private String sex;// 用户性别
	private Date birthday;// 出生日期
	private String email;// 邮箱

	private TDep dept;// 关联对象，一对一关联

	private String realname;// 真实姓名
	private int creator;// 创建人，不修改
	private Date creatime;// 创建时间，不修改
	private int updator;// 修改人
	private Date updatetime;// 修改时间，获取系统时间
	private String pic;// 用户头像
	private int isenabled;// 是否可用，1可用，-1不可用
	private String isenabledTxt;
	private String birthdayTxt;
	
	

	public String getBirthdayTxt() {
		return DateUtil.getStrDate(birthday);
	}

	

	public String getIsenabledTxt() {
		if(isenabled==1){
			return "可用";
		}else{
			return "不可用";
		}
		
	}


	// 性别显示，从内存中获取性别信息，判断并设置显示性别的信息
/*	private String sexTxt;

	// 获取显示性别
	public String getSexTxt() {
		// 判断sex是否等于1
		if ("1".equals(sex)) {
			// 显示男
			return "男";
		} else {
			// 显示女
			return "女";
		}

	}*/

	// 用户一对多关联权限列表
	private List<TPermission> permissions;

	// 用户权限菜单，从内存中获取权限，判断权限的pid存放到定义好的子权限集合中，并显示出来
	private List<TPermission> menu = new ArrayList<TPermission>();
	
	public List<TPermission> getMenu() {
		//每次循环一级权限前，先清空权限集合，因为只new一次menu对象，防止页面重新加载时，集合重复存放权限
		menu.clear();
		// 遍历集合中的权限，取出一级权限
		for (TPermission per1 : permissions) {
			// 一级权限
			if (per1.getPid() == 0) {
				//每次循环二级权限前，先清空权限集合，因为只new一次menu对象，防止页面重新加载时，集合重复存放权限
				per1.getChildren().clear();
				// 遍历集合中的权限，取出二级权限
				for (TPermission per2 : permissions) {
					// 二级权限的pid==一级权限的id
					if (per2.getPid() == per1.getId()) {
						// 二级权限存放到一级权限集合中
						per1.getChildren().add(per2);
					}
				}
				// 一级菜单存放到大菜单中
				menu.add(per1);
			}
		}
		// 返回权限菜单
		return menu;
	}

	public List<TPermission> getPermissions() {

		return permissions;
	}

	public void setPermissions(List<TPermission> permissions) {
		this.permissions = permissions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TDep getDept() {
		return dept;
	}

	public void setDept(TDep dept) {
		this.dept = dept;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
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

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getIsenabled() {
		return isenabled;
	}

	public void setIsenabled(int isenabled) {
		this.isenabled = isenabled;
	}

}
