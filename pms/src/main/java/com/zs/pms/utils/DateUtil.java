package com.zs.pms.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	/**
	 * 展示日期的方法
	 */
	public static void showToday() {
		// 通过调用获得日历实例的方法来得到日历实例
		Calendar cal = Calendar.getInstance();
		// 调用日历类的获得方法，获得年
		int y = cal.get(Calendar.YEAR);
		// 调用日历类的获得方法，获得月，因为月份默认从0~11月，所以加1
		int m = cal.get(Calendar.MONTH) + 1;
		// 调用日历类的获得方法，获得日
		int d = cal.get(Calendar.DATE);
		// 调用日历类的获得方法，获得小时
		int hh = cal.get(Calendar.HOUR);
		// 调用日历类的获得方法，获得小时，24小时
		int hh1 = cal.get(Calendar.HOUR_OF_DAY);
		// 调用日历类的获得方法，获得分钟，12小时制
		int mm = cal.get(Calendar.MINUTE);
		// 调用日历类的获得方法，获得秒
		int ss = cal.get(Calendar.SECOND);
		// System.out.println("当前时间："+y+"-"+m+"-"+d+" "+hh1+":"+mm+":"+ss);
		// 增加2个月
		cal.add(Calendar.MONTH, 2);

	}

	/**
	 * 将Date类型数据转换成字符串类型数据的方法
	 * 
	 * @param time
	 *            需要转换的Date类型数据
	 * @param pattern
	 *            Date类型日期格式：yyyy-MM-dd HH:mm:ss y：年 M：月 d：日 H：24小时制的小时
	 *            h：12小时制的小时 m：分钟 s：秒
	 * @return 转换后的字符串
	 */
	public static String getDateToString(Date time, String pattern) {
		// 创建DateFormat类的子类的对象df，同时将日期和格式作为形参传入到构造函数中
		DateFormat df = new SimpleDateFormat(pattern);
		// 调用DateFormat类的format方法，format方法可以将Date类型数据转换成字符串类型
		// 将需要形参格式化的日期传入到方法中，并返回获得日期
		return df.format(time);
	}

	/**
	 * 将字符串类型数据转换成Date类型数据的方法
	 * 
	 * @param time
	 *            需要转换的字符串类型数据
	 * @param pattern
	 *            Date类型日期格式：yyyy-MM-dd HH:mm:ss y：年 M：月 d：日 H：24小时制的小时
	 *            h：12小时制的小时 m：分钟 s：秒
	 * @return 返回字符串类型数据
	 * @throws ParseException
	 */
	public static Date getStringToDate(String time, String pattern) throws ParseException {
		DateFormat df = new SimpleDateFormat(pattern);
		return df.parse(time);

	}

	//日期格式转字符串格式
	public static String getStrDate(Date date) {
		// 通过调用获得日历实例的方法来得到日历实例
		Calendar cal = Calendar.getInstance();
		//设置传入的日期
		cal.setTime(date);
		// 调用日历类的获得方法，获得年
		int y = cal.get(Calendar.YEAR);
		// 调用日历类的获得方法，获得月，因为月份默认从0~11月，所以加1
		int m = cal.get(Calendar.MONTH) + 1;
		// 调用日历类的获得方法，获得日
		int d = cal.get(Calendar.DATE);
		//返回字符串类型格式的日期
		return y+"-"+m+"-"+d;
	}
}
