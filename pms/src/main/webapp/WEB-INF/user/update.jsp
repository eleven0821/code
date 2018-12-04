<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 引入标签库 -->
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>






<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<link href="../res/lecheng/css/admin.css" rel="stylesheet" type="text/css" />
<link href="../res/common/css/theme.css" rel="stylesheet" type="text/css" />
<link href="../res/common/css/jquery.validate.css" rel="stylesheet"
	type="text/css" />
<link href="../res/common/css/jquery.treeview.css" rel="stylesheet"
	type="text/css" />
<link href="../res/common/css/jquery.ui.css" rel="stylesheet"
	type="text/css" />

<!-- <script src="/thirdparty/ckeditor/ckeditor.js" type="text/javascript"></script> -->
<!-- <script src="/thirdparty/My97DatePicker/WdatePicker.js" type="text/javascript"></script> -->
<script type="text/javascript" src="res/fckeditor/fckeditor.js"></script>
<script src="../res/common/js/jquery.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="../res/common/js/lecheng.js" type="text/javascript"></script>
<script src="../res/lecheng/js/admin.js" type="text/javascript"></script>
<!-- 引入jQuery -->
<script type="text/javascript" language="javascript" src="js/jquery-1.11.0.min.js"></script>
<!-- 引入日期控件 -->
<!-- 引时间控件 -->
<script type="text/javascript" src="../js/DatePicker/WdatePicker.js"></script>
<script type="text/javascript" src="../res/fckeditor/fckeditor.js"></script>
<script src="../res/common/js/jquery.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.ext.js" type="text/javascript"></script>
<script src="../res/common/js/jquery.form.js" type="text/javascript"></script>
<script src="../res/common/js/lecheng.js" type="text/javascript"></script>
<script src="../res/lecheng/js/admin.js" type="text/javascript"></script>

<link rel="stylesheet" href="../res/css/style.css" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>user-update</title>

<!-- 修改用户表单验证 -->
<script type="text/javascript">
	//用户名：数字+字母，结束之前不能全部都是数字，6-16
	var CHKLOGINNAME="^(?![0-9]+$)[a-zA-Z0-9]{6,16}$";
	
	//出生日期     yyyy-MM-dd  月份1-12     日期1-31
	var CHKDATE="^[0-9]{4}-0?[1-9]|1[0-2]-0?[1-9]|[1-2][0-9]|3[0-1]$";
	//邮箱xxxxxx@xxx.com,可以包含_      企业邮箱qwe@huewei.com.cn
	var CHKEMAIL="^[a-zA-Z0-9_]+@[a-z0-9]{2,5}(\\.[a-z]{2,3}){1,2}$";
	//真实姓名
	var CHKREALNAME="^[\u4e00-\u9fa5]{2,}$";
	
	//验证用户名
	function chkloginname(){
		//获取用户名
		var loginname=$("#loginname").val();
		//定义匹配用户名的正则表达式
		var reg=new RegExp(CHKLOGINNAME);
		//判断输入的用户名是否匹配规定好的正则表达式
		if(reg.test(loginname)){//表示输入用户名正确
			//调用检查用户名是否唯一的方法，作为判断条件
			if(chkExistLoginname(loginname)){
				//用户名不重复，返回true
				return true;
			}else{
				//用户重复，返回false
				return false;
			}
		}else{//输入用户名错误
			//给用户名是否输入成功的元素对象文本内容赋值
			$("#resultName").html("用户名必须包含数字和字母，并且不能低于六位");
			//给用户名是否输入成功的元素对象的颜色属性赋值
			$("#resultName").css("color","red");
			//清空用户名文本框
			//$("#loginname").val("");
		
			//给方法一个返回值为false，用于使用onBlur()失焦方法判断
			return false;
			
		}
	}
	
	//检查用户名是否重复
	function chkExistLoginname(loginname){
		var flag=false;
		$.ajax({
			//请求路径
			url:'chkuser.do',
			//请求方式
			type:'post',
			//请求参数
			data:'type=1&loginname='+loginname,
			//是否异步
			async:false,
			//预期服务器返回的数据类型
			dataType:'text',
			//响应成功调用回调函数
			success:function(flag){
				if(flag=='true'){//没有重复
					$("#resultName").html("✔");
					$("#resultName").css("color","green");
					flag=true;
				}else{
					$("#resultName").html("此用户名已存在");
					$("#resultName").css("color","red");
					flag=false;
				}
			},
			error:function(){
				alert('请求数据失败。。。');
			}
		});
		return flag;
	}
	
	
	//验证真实姓名
	function chkrealname(){
		//获取真实姓名
		var realname=$("#realname").val();
		//定义匹配真实姓名的正则表达式
		var reg=new RegExp(CHKREALNAME);
		//判断输入的真实姓名是否匹配规定好的正则表达式
		if(reg.test(realname)){//表示输入真实姓名正确
			//给真实姓名是否输入成功的元素对象文本内容赋值
			$("#resultRealname").html("✔");
			//给真实姓名是否输入成功的元素对象的颜色属性赋值
			$("#resultRealname").css("color","green");
			//给方法一个返回值为true，用于使用onBlur()失焦方法判断
			return true;
		}else{//输入真实姓名错误
			//给真实姓名是否输入成功的元素对象文本内容赋值
			$("#resultRealname").html("真实姓名必须使用汉字，至少两个字");
			//给真实姓名是否输入成功的元素对象的颜色属性赋值
			$("#resultRealname").css("color","red");
			//给方法一个返回值为false，用于使用onBlur()失焦方法判断
			return false;
		}
	}
	
	
	//验证邮箱
	function chkemail(){
		//获取邮箱
		var email=$("#email").val();
		//定义匹配邮箱的正则表达式
		var reg=new RegExp(CHKEMAIL);
		//判断输入的邮箱是否匹配规定好的正则表达式
		if(reg.test(email)){//表示输入用户邮箱正确
			//调用检查邮箱是否重复的方法，作为判断条件
			if(chkExistEmail(email)){
				//邮箱不重复，返回true
				return true;
			}else{
				//邮箱重复，返回false
				return false;
			}
		}else{//输入用户邮箱错误
			//给邮箱是否输入成功的元素对象文本内容赋值
			$("#resultEmail").html("邮箱格式不正确，请重新输入");
			//给邮箱是否输入成功的元素对象的颜色属性赋值
			$("#resultEmail").css("color","red");
			//给方法一个返回值为false，用于使用onBlur()失焦方法判断
			return false;
		}
	}
	
	//检查邮箱是否唯一
	function chkExistEmail(email){
		var flag=false;
		$.ajax({
			//请求路径
			url:'chkuser.do',
			//请求方式
			type:'post',
			//请求参数
			data:'type=2&email='+email,
			//是否异步
			async:false,
			//预期服务器返回的数据类型
			dataType:'text',
			//响应成功调用回调函数
			success:function(flag){
				if(flag=='true'){//没有重复
					$("#resultEmail").html("✔");
					$("#resultEmail").css("color","green");
					flag=true;
				}else{
					$("#resultEmail").html("此邮箱已存在");
					$("#resultEmail").css("color","red");
					flag=false;
				}
			},
			error:function(){
				alert('请求数据失败。。。');
			}
		});
		return flag;
	}
	
	
	//验证用户所有用户信息是否匹配正则表达式
	 function chkAll(){
		return chkloginname()&&chkrealname()&&chkemail()
	
	}
	

	//ajax异步处理显示部门信息
	//文档就绪事件
	$(function(){
		//部门下拉框change事件
		$("#dep1").change(
			//部门下拉框二级部门
			function(){
				//清空二级部门下拉框
				$("#dep2").empty();
				//ajax异步提交二级部门
				$.post(
					"getdep.do", //提交数据到url
					{pid : this.value}, //json类型数据，传值，this指#dep2
					function(data) { //服务器响应成功后，调用回调函数，data自定义名
						//新增传递数据不为空
						if(data!=null){
							//循环遍历二级部门数据data
							$(data).each(
								//调用JSONArray的fromObject(对象名)，通过响应的getWriter()获取写入对象，write()写入
								//SpringMVC自动将对象数据转成json类型数据
								function(){
									//添加数据到二级部门下拉框中
									$("#dep2").append("<option value="+this.id+">"+ this.name+ "</option>");
								}		
							);
						}
										
					}, 
					"json" //返回数据类型
				)
							
			}
						
		);

	});

	

</script>


<style type="">
.h2_ch a:hover,.h2_ch a.here {
	color: #FFF;
	font-weight: bold;
	background-position: 0px -32px;
}

.h2_ch a {
	float: left;
	height: 32px;
	margin-right: -1px;
	padding: 0px 16px;
	line-height: 32px;
	font-size: 14px;
	font-weight: normal;
	border: 1px solid #C5C5C5;
	background: url('../res/lecheng/img/admin/bg_ch.gif') repeat-x scroll 0%
		0% transparent;
}

a {
	color: #06C;
	text-decoration: none;
}
</style>

</head>
<body>
	<img src="images/logo4.png" />
	<div class="box-positon">
		<div class="rpos">当前位置: 用户管理 - 修改</div>
		<form class="ropt">
			<!-- 新增完毕，页面跳转到用户信息页面 -->
			<input type="submit" onclick="this.form.action='list.do';"
				value="返回列表" class="return-button" />
		</form>
		<div class="clear"></div>
	</div>

	<div class="body-box" style="float: right">
		<form id="jvForm" action="update.do?id=${USER.id }" method="post">
			<table cellspacing="1" cellpadding="2" width="100%" border="0"
				class="pn-ftable">
				<tbody id="tab_1">
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">
							<span class="pn-frequired"></span> 
							<span class="pn-frequired">${MSG }</span>
						</td>
					</tr>


					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">
							用户名:
						</td>
						<td width="80%" class="pn-fcontent">
							<input type="text" class="required" name="loginname" id="loginname" 
							value="${USER.loginname }" maxlength="10" readonly="readonly"  />
							<!-- <span id="resultName"></span> -->
						</td>
					</tr>
					
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">
							密码:
						</td>
						<td width="80%" class="pn-fcontent">
							<input type="password" class="required" name="password" id="password" 
							value="${USER.password }" maxlength="10"   />
							<!-- <span id="resultName"></span> -->
						</td>
						
					</tr>
					
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">
							确认密码:
						</td>
						<td width="80%" class="pn-fcontent">
							<input type="password" class="required" name="password" id="password" 
							value="${USER.password }" maxlength="10"   />
							<!-- <span id="resultName"></span> -->
						</td>
						
					</tr>
					
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">
							 真实姓名:
						</td>
						<td width="80%" class="pn-fcontent"><input type="text"
							class="required" name="realname" id="realname" value="${USER.realname }"
							maxlength="100"  />
							<!-- <span id="resultRealname"></span> -->
						</td>	
					</tr>
					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">性别:</td>
						<td width="80%" class="pn-fcontent">
						<c:if test="${USER.sex=='男' }">	
							<input type="radio" name="sex" value="男" checked="checked" />男 
							<input type="radio" name="sex" value="女" />女 
						</c:if> 
						<c:if test="${USER.sex!='男' }">
							<input type="radio" name="sex" value="男" />男 
							<input type="radio" name="sex" value="女" checked="checked" />女 
						</c:if>
						</td>
					</tr>

					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">出生日期:</td>
						<td width="80%" class="pn-fcontent">
						<input type="text" class="Wdate" name="birthday" value="${USER.birthdayTxt }"
							maxlength="100" onclick="WdatePicker()"  /></td>
					</tr>

					

					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">部门:</td>
						<td width="80%" class="pn-fcontent">
						<select id="dep1" name="dep1">
								<c:forEach items="${DEP1 }" var="dep1">
									<!-- 显示所属部门，该用户所在部门的上级部门id等于一级部门id -->
									<c:if test="${USER.dept.pid==dep1.id }">
										<option value="${dep1.id }" selected="selected">${dep1.name }</option>
									</c:if>
									<!-- 显示其他部门 -->
									<c:if test="${USER.dept.pid!=dep1.id }">
										<option value="${dep1.id }">${dep1.name }</option>
									</c:if>
								</c:forEach>
						</select>
						
						<select id="dep2" name="dept.id">
								<c:forEach items="${DEP2 }" var="dep2">
									<!-- 显示所属部门，该用户所在部门id等于二级部门id -->
									<c:if test="${USER.dept.id==dep2.id }">
										<option value="${dep2.id }" selected="selected">${dep2.name }</option>
									</c:if>
									<!-- 显示其他部门 -->
									<c:if test="${USER.dept.id!=dep2.id }">
										<option value="${dep2.id }">${dep2.name }</option>
									</c:if>
								</c:forEach>
						</select>
						</td>
					</tr>

					<tr>
						<td width="20%" class="pn-flabel pn-flabel-h">
							邮箱:
						</td>
						<td width="80%" class="pn-fcontent">
						<input type="text" value="${USER.email }" class="required" 
						name="email" id="email" maxlength="80"  />
							<!-- <span id="resultEmail"></span> -->
						</td>
					</tr>
					<!-- 因为页面没有设置登录名和是否可用，所以需要使用隐藏域将这两项数据带回到数据库表中 -->
					<input type="hidden" name="isenabled" value="${USER.isenabled }" />
					<input type="hidden" name="id" value="${USER.id }" />
					
					<tbody>
						<tr>
							<td class="pn-fbutton" colspan="2"><input type="submit"
								class="submit" value="提交" /> &nbsp; <input type="reset"
								class="reset" value="重置" /></td>
						</tr>
					</tbody>
			</table>
		</form>
	</div>
</body>
</html>