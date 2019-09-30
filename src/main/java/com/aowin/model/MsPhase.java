package com.aowin.model;

/**
 * 用户权限类
 * @author Peter
 *
 */
public class MsPhase {

	/**
	 * 权限id
	 */
	private Integer phaseid;
	/**
	 * 权限路径
	 */
	private String url;
	/**
	 * 权限描述
	 */
	private String description;
	/**
	 * 获得权限
	 * @return
	 */
	public Integer getPhaseid() {
		return phaseid;
	}
	/**
	 * 设置权限
	 * @param phaseid
	 */
	public void setPhaseid(Integer phaseid) {
		this.phaseid = phaseid;
	}
	/**
	 * 获得权路径
	 * @return
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置权限路径
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获得权限描述
	 * @return
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * 设置权限描述
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Msphase [phaseid=" + phaseid + ", url=" + url + ", description=" + description + "]";
	}
	
}
