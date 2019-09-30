package com.aowin.dao;

import java.util.List;

import com.aowin.model.Bicycle_catagory;

/**
 * 车辆类型的数据库操作
 * @author Peter
 *
 */
public interface Bicycle_catagoryDao {
	/**
	 * 查询所有的类型信息List
	 */
	List<Bicycle_catagory> getBicycle_catagoryList();
	/**
	 * 根据车辆id查询车辆信息
	 * @param bicycle_id
	 * @return
	 */
	Bicycle_catagory getBicycle_catagoryById(Integer bicycle_id);
}
