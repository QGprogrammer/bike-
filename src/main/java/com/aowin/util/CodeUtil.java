package com.aowin.util;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * 给model中的编号自动编号
 * @author Peter
 *
 */
@Component
public class CodeUtil {
	@Resource
	private DateUtil dateUtil;
	/**
	 * 给采购主单编号
	 */
	public String getBicycle_orderCode(Date date) {
		return "order" + dateUtil.getDateCode(date);
	}
}
