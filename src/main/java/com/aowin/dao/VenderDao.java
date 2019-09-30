package com.aowin.dao;

import java.util.List;

import com.aowin.model.Vender;

/**
 * 供应商的数据库操作
 * @author Peter
 *
 */
public interface VenderDao {

	/**
	 * 查询供应商id 和 名字的List
	 */
	List<Vender> getVenderList();
}
