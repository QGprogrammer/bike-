package com.aowin.model;

/**
 * 自行车类
 * @author Peter
 *
 */
public class Bicycle_info {
	/**
	 * 自行车id
	 */
	private Long bicycle_id;
	/**
	 * 自行车编号
	 */
	private String bicycle_code;
	/**
	 * 自行车状态
	 */
	private Integer status;
	/**
	 * 车桩id
	 */
	private Long pile_id;
	/**
	 * 销毁日期
	 */
	private String destroy_date;
	/**
	 * 用户id
	 */
	private Integer user_id;
	/**
	 * 操作时间
	 */
	private String operator_time;
	/**
	 * 卡id
	 */
	private Long card_id;
	/**
	 * 备注
	 */
	private String remark;
	public Long getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(Long bicycle_id) {
		this.bicycle_id = bicycle_id;
	}
	public String getBicycle_code() {
		return bicycle_code;
	}
	public void setBicycle_code(String bicycle_code) {
		this.bicycle_code = bicycle_code;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getPile_id() {
		return pile_id;
	}
	public void setPile_id(Long pile_id) {
		this.pile_id = pile_id;
	}
	public String getDestroy_date() {
		return destroy_date;
	}
	public void setDestroy_date(String destroy_date) {
		this.destroy_date = destroy_date;
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
	public Long getCard_id() {
		return card_id;
	}
	public void setCard_id(Long card_id) {
		this.card_id = card_id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Bicycle_info [bicycle_id=" + bicycle_id + ", bicycle_code=" + bicycle_code + ", status=" + status
				+ ", pile_id=" + pile_id + ", destroy_date=" + destroy_date + ", user_id=" + user_id
				+ ", operator_time=" + operator_time + ", card_id=" + card_id + ", remark=" + remark + "]";
	}
	
	
	
}
