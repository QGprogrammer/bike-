package com.aowin.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * 日期有关的util
 * @author Peter
 *
 */
@Component
public class DateUtil {

	/**
	 * 获得时间字符串
	 * @param date
	 * @return
	 */
	public  String getDateTime(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = sdf.format(date);
		return dateTime;
	}
	/**
	 * 获得日期字符串
	 * @param date
	 * @return
	 */
	public  String getDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateTime = sdf.format(date);
		return dateTime;
	}
	/**
	 * 时间编码
	 * @param date
	 * @return
	 */
	public  String getDateCode(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateTime = sdf.format(date);
		return dateTime;
	}
}
