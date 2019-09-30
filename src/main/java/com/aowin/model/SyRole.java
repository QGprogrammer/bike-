package com.aowin.model;

import java.util.List;

/**
 * 角色类
 * @author Peter
 *
 */
public class SyRole {
	/**
	 * 角色id
	 */
	private Integer role_id;
	/**
	 * 角色名字
	 */
	private String role_name;
	/**
	 * 角色描述
	 */
	private String role_describe;
	/**
	 * 权限对象集合
	 */
	private List<MsPhase> msPhaseList;
	/**
	 * 获得角色id
	 * @return
	 */
	public Integer getRole_id() {
		return role_id;
	}
	/**
	 * 设置角色id
	 * @param role_id
	 */
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	/**
	 * 获得角色名字
	 * @return
	 */
	public String getRole_name() {
		return role_name;
	}
	/**
	 * 设置角色名字
	 * @param role_name
	 */
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	/**
	 * 获得角色描述
	 * @return
	 */
	public String getRole_describe() {
		return role_describe;
	}
	/**
	 * 设置角色描述
	 * @param role_describe
	 */
	public void setRole_describe(String role_describe) {
		this.role_describe = role_describe;
	}
	/**
	 * 获得该角色对应的权限集合
	 * @return
	 */
	public List<MsPhase> getMsPhaseList() {
		return msPhaseList;
	}
	/**
	 * 设置该角色对应的权限集合
	 * @return
	 */
	public void setMsPhaseList(List<MsPhase> msPhaseList) {
		this.msPhaseList = msPhaseList;
	}
	@Override
	public String toString() {
		return "SyRole [role_id=" + role_id + ", role_name=" + role_name + ", role_describe=" + role_describe
				+ ", msPhaseList=" + msPhaseList + "]";
	}
	
	
}
