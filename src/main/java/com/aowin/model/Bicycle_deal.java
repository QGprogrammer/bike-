package com.aowin.model;

import java.util.List;

/**
 * 业务流水的记录
 * @author Peter
 *
 */
public class Bicycle_deal {
	
	/**
	 * 创建时间
	 */
	private String create_time;
	/**
	 * 业务名称
	 */
	private String deal_name;
	/**
	 * 业务类型
	 */
	private Integer deal_type;
	/**
	 * 关联的业务记录id
	 */
	private Long record_id;
	/**
	 * 卡id
	 */
	private Long card_id;
	/**
	 * 是否发生费用
	 */
	private Integer is_fee;
	/**
	 * 费用金额
	 */
	private Double chg_money;
	/**
	 * 费用类型
	 */
	private Integer fee_type;
	/**
	 * 车桩id
	 */
	private Integer pile_id;
	/**
	 * 用户id
	 */
	private Integer user_id;
	/**
	 * 车辆idList
	 */
	private List<Bicycle_info> bicycle_infoList;
	/**
	 * 车辆id
	 */
	private Long bicycle_id;
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getDeal_name() {
		return deal_name;
	}
	public void setDeal_name(String deal_name) {
		this.deal_name = deal_name;
	}
	public Integer getDeal_type() {
		return deal_type;
	}
	public void setDeal_type(Integer deal_type) {
		this.deal_type = deal_type;
	}
	public Long getRecord_id() {
		return record_id;
	}
	public void setRecord_id(Long record_id) {
		this.record_id = record_id;
	}
	public Long getCard_id() {
		return card_id;
	}
	public void setCard_id(Long card_id) {
		this.card_id = card_id;
	}
	public Integer getIs_fee() {
		return is_fee;
	}
	public void setIs_fee(Integer is_fee) {
		this.is_fee = is_fee;
	}
	public Double getChg_money() {
		return chg_money;
	}
	public void setChg_money(Double chg_money) {
		this.chg_money = chg_money;
	}
	public Integer getFee_type() {
		return fee_type;
	}
	public void setFee_type(Integer fee_type) {
		this.fee_type = fee_type;
	}
	public Integer getPile_id() {
		return pile_id;
	}
	public void setPile_id(Integer pile_id) {
		this.pile_id = pile_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public List<Bicycle_info> getBicycle_infoList() {
		return bicycle_infoList;
	}
	public void setBicycle_infoList(List<Bicycle_info> bicycle_infoList) {
		this.bicycle_infoList = bicycle_infoList;
	}
	public Long getBicycle_id() {
		return bicycle_id;
	}
	public void setBicycle_id(Long bicycle_id) {
		this.bicycle_id = bicycle_id;
	}
	
}
