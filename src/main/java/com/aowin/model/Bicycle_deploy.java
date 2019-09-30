package com.aowin.model;

/**
 * 车辆调度类
 * @author Peter
 *
 */
public class Bicycle_deploy {
	/**
	 * 调度id
	 */
	private Long deploy_id;
	/**
	 * 车辆id
	 */
	private Long bicycle_id;
	/**
	 * 调入车桩id
	 */
	private Long to_pile_id;
	/**
	 * 调入时间
	 */
	private String to_time;
	/**
	 * 调入原因
	 * 
	 */
	private Integer to_reason;
	public Long getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(Long bicycle_id) {
		this.bicycle_id = bicycle_id;
	}
	public Long getTo_pile_id() {
		return to_pile_id;
	}
	public void setTo_pile_id(Long to_pile_id) {
		this.to_pile_id = to_pile_id;
	}
	public String getTo_time() {
		return to_time;
	}
	public void setTo_time(String to_time) {
		this.to_time = to_time;
	}
	public Integer getTo_reason() {
		return to_reason;
	}
	public void setTo_reason(Integer to_reason) {
		this.to_reason = to_reason;
	}
	public Long getDeploy_id() {
		return deploy_id;
	}
	public void setDeploy_id(Long deploy_id) {
		this.deploy_id = deploy_id;
	}
	
}
