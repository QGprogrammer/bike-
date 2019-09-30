package com.aowin.model;


/**
 * 用户授权类
 * @author Peter
 *
 */
public class SyPermission {

	/**
	 * 授权id
	 */
	private Integer permissionid;
	/**
	 * 角色id
	 */
	private Integer roleid;
	/**
	 * 权限id
	 */
	private Integer phaseid;
	/**
	 * 获得授权
	 * @return
	 */
	public Integer getPermissionid() {
		return permissionid;
	}
	/**
	 * 设置授权
	 * @param permissionid
	 */
	public void setPermissionid(Integer permissionid) {
		this.permissionid = permissionid;
	}
	/**
	 * 获得角色id
	 * @return
	 */
	public Integer getRoleid() {
		return roleid;
	}
	/**
	 * 设置角色id
	 * @param roleid
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	/**
	 * 获得权限id
	 * @return
	 */
	public Integer getPhaseid() {
		return phaseid;
	}
	/**
	 * 设置权限id
	 * @param phaseid
	 */
	public void setPhaseid(Integer phaseid) {
		this.phaseid = phaseid;
	}
	@Override
	public String toString() {
		return "SyPermission [permissionid=" + permissionid + ", roleid=" + roleid + ", phaseid=" + phaseid + "]";
	}
	
	
	
}
