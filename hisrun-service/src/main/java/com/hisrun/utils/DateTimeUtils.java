package com.hisrun.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeUtils {
	/**
	 * 将日期格式转换成字段串格式
	 * 
	 * @author ZhangQiong
	 * @param date
	 * @return 将date类型按'yyyy-MM-dd'转成字符串
	 */
	public static String dateToYmdStr(Date date) {
		DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
		if (date != null) {
			String ss = dft.format(date);
			return ss;
		} else {
			return "";
		}
	}

	/**
	 * 取传入时间年份
	 * 
	 * @param date
	 * @return 年份
	 * @author yangzt
	 */
	public static String dateToYearStr(Date date) {
		DateFormat dft = new SimpleDateFormat("yyyy");
		if (date != null) {
			String ss = dft.format(date);
			return ss;
		} else {
			return "";
		}
	}

	/**
	 * 取当前时间年份
	 * 
	 * @param date
	 * @return 年份
	 * @author yangzt
	 */
	public static String dateToYearStr() {
		DateFormat dft = new SimpleDateFormat("yyyy");
		return dft.format(new Date());
	}

	public static void main(String[] args) {
		System.out.print(DateTimeUtils.dateToYearStr(new Date()));
	}

}
