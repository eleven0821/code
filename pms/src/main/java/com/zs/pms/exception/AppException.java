package com.zs.pms.exception;

/**
 * 自定义异常，应用异常
 * */
public class AppException extends Exception {
	//异常码
			private int errCode;
			//异常信息
			private String errMsg;
			/**
			 * 带参的构造函数，初始化实例变量
			 * @param errCode 异常码
			 * @param errMsg 异常信息
			 */
			public AppException(int errCode, String errMsg) {
				//方法的形参给类的属性赋值
				this.errCode = errCode;
				this.errMsg = errMsg;
			}
			//所有属性的setter和getter
			public int getErrCode() {
				return errCode;
			}
			public void setErrCode(int errCode) {
				this.errCode = errCode;
			}
			public String getErrMsg() {
				return errMsg;
			}
			public void setErrMsg(String errMsg) {
				this.errMsg = errMsg;
			}
}
