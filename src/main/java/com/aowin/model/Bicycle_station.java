package com.aowin.model;

/**
 * 车辆站点信息类
 * @author Peter
 *
 */
public class Bicycle_station {
	/**
	 * 站点id
	 */
	private Long station_id;
	/**
	 * 站点名字
	 */
	private String station_name;
	/**
	 *  站点编号
	 */
	private String station_code;
	/**
	 * 经度
	 */
	private Double longitude;
	/**
	 * 维度
	 */
	private Double latitude;
	/**
	 * 车桩数量
	 */
	private Integer bicycle_pile_num;
	/**
	 * 地址
	 */
	private String address;
	/**
	 * 负责人
	 */
	private String person_in_charge;
	/**
	 * 建造日期
	 */
	private String build_time;
	/**
	 * 营运日期
	 */
	private String run_time;
	/**
	 * 经办人
	 */
	private Integer user_id;
	/**
	 * 创建日期
	 */
	private String create_time;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 入站的车数量
	 * @return
	 */
	private Integer bicycle_num;
	public Long getStation_id() {
		return station_id;
	}
	public void setStation_id(Long station_id) {
		this.station_id = station_id;
	}
	public String getStation_name() {
		return station_name;
	}
	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}
	public String getStation_code() {
		return station_code;
	}
	public void setStation_code(String station_code) {
		this.station_code = station_code;
	}
	public Double getlongitude() {
		return longitude;
	}
	public void setlongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Integer getBicycle_pile_num() {
		return bicycle_pile_num;
	}
	public void setBicycle_pile_num(Integer bicycle_pile_num) {
		this.bicycle_pile_num = bicycle_pile_num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPerson_in_charge() {
		return person_in_charge;
	}
	public void setPerson_in_charge(String person_in_charge) {
		this.person_in_charge = person_in_charge;
	}
	public String getBuild_time() {
		return build_time;
	}
	public void setBuild_time(String build_time) {
		this.build_time = build_time;
	}
	public String getRun_time() {
		return run_time;
	}
	public void setRun_time(String run_time) {
		this.run_time = run_time;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getBicycle_num() {
		return bicycle_num;
	}
	public void setBicycle_num(Integer bicycle_num) {
		this.bicycle_num = bicycle_num;
	}
	
}
