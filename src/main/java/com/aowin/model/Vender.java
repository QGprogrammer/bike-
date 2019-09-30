package com.aowin.model;

/**
 * 供应商类
 * @author Peter
 *
 */
public class Vender {
	/**
	 * 供应商ID
	 */
	private long vender_id;
	/**
	 * 供应商名字
	 */
	private String vender_name;
	/**
	 * 获取供应商id
	 * @return
	 */
	public long getVender_id() {
		return vender_id;
	}
	/**
	 * 设置供应商id
	 * @param vender_id
	 */
	public void setVender_id(long vender_id) {
		this.vender_id = vender_id;
	}
	/**
	 * 获取供应商名字
	 * @return
	 */
	public String getVender_name() {
		return vender_name;
	}
	/**
	 * 设置供应商名字
	 * @param vender_name
	 */
	public void setVender_name(String vender_name) {
		this.vender_name = vender_name;
	}
	@Override
	public String toString() {
		return "Vender [vender_id=" + vender_id + ", vender_name=" + vender_name + "]";
	}
	
	
	
}
