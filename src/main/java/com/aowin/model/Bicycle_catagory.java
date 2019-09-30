package com.aowin.model;
/**
 * 车辆类型
 * @author Peter
 *
 */
public class Bicycle_catagory {
	/**
	 * 类型id
	 */
	private Long catagory_id;
	/**
	 * 类型名字
	 */
	private String catagory_name;
	/**
	 * 车辆编号
	 */
	private String bicycle_code;
	/**
	 * 框架类型
	 */
	private String frame_type;
	/**
	 * 轮胎类型
	 */
	private String tire_type;
	/**
	 * 重量
	 */
	private Double weight;
	/**
	 * 长度
	 */
	private Double length;
	/**
	 * 高度
	 */
	private Double height;
	/**
	 * 铃类型
	 */
	private String ring_type;
	/**
	 * 后座类型
	 */
	private String backseat;
	/**
	 * 车座
	 */
	private String bicycle_seat;
	/**
	 * 把手
	 */
	private String handbrake;
	public Long getCatagory_id() {
		return catagory_id;
	}
	public void setCatagory_id(Long catagory_id) {
		this.catagory_id = catagory_id;
	}
	public String getCatagory_name() {
		return catagory_name;
	}
	public void setCatagory_name(String catagory_name) {
		this.catagory_name = catagory_name;
	}
	public String getBicycle_code() {
		return bicycle_code;
	}
	public void setBicycle_code(String bicycle_code) {
		this.bicycle_code = bicycle_code;
	}
	public String getFrame_type() {
		return frame_type;
	}
	public void setFrame_type(String frame_type) {
		this.frame_type = frame_type;
	}
	public String getTire_type() {
		return tire_type;
	}
	public void setTire_type(String tire_type) {
		this.tire_type = tire_type;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getLength() {
		return length;
	}
	public void setLength(Double length) {
		this.length = length;
	}
	public Double getHeight() {
		return height;
	}
	public void setHeight(Double height) {
		this.height = height;
	}
	public String getRing_type() {
		return ring_type;
	}
	public void setRing_type(String ring_type) {
		this.ring_type = ring_type;
	}
	public String getBackseat() {
		return backseat;
	}
	public void setBackseat(String backseat) {
		this.backseat = backseat;
	}
	public String getBicycle_seat() {
		return bicycle_seat;
	}
	public void setBicycle_seat(String bicycle_seat) {
		this.bicycle_seat = bicycle_seat;
	}
	public String getHandbrake() {
		return handbrake;
	}
	public void setHandbrake(String handbrake) {
		this.handbrake = handbrake;
	}
	
}
