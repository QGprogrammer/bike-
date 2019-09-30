package com.aowin.model;

/**
 * 车桩类
 * @author Peter
 *
 */
public class Bicycle_pile {
	/**
	 * 车桩id
	 */
	private Long pile_id;
	/**
	 * 车桩编号
	 */
	private String pile_code;
	/**
	 * 供应商id
	 */
	private Integer vender_id;
	/**
	 * 站点id
	 */
	private Long station_id;
	/**
	 * 状态
	 */
	private Integer status;
	/**
	 * 安装日期
	 */
	private String install_time;
	/**
	 * 拆解日期
	 */
	private String disassembly_time;
	/**
	 * 用户id
	 */
	private Integer user_id;
	/**
	 * 操作日期
	 */
	private String operator_time;
	/**
	 * 车辆id
	 */
	private String bicycle_id;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 站点名称
	 */
	private String station_name;
	public Long getPile_id() {
		return pile_id;
	}
	public void setPile_id(Long pile_id) {
		this.pile_id = pile_id;
	}
	public String getPile_code() {
		return pile_code;
	}
	public void setPile_code(String pile_code) {
		this.pile_code = pile_code;
	}
	public Integer getVender_id() {
		return vender_id;
	}
	public void setVender_id(Integer vender_id) {
		this.vender_id = vender_id;
	}
	public Long getStation_id() {
		return station_id;
	}
	public void setStation_id(Long station_id) {
		this.station_id = station_id;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getInstall_time() {
		return install_time;
	}
	public void setInstall_time(String install_time) {
		this.install_time = install_time;
	}
	public String getDisassembly_time() {
		return disassembly_time;
	}
	public void setDisassembly_time(String disassembly_time) {
		this.disassembly_time = disassembly_time;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getOperator_time() {
		return operator_time;
	}
	public void setOperator_time(String operator_time) {
		this.operator_time = operator_time;
	}
	public String getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(String bicycle_id) {
		this.bicycle_id = bicycle_id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	
	
}
