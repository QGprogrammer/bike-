package com.aowin.model;

/**
 * 采购主单信息
 * @author Peter
 *
 */
public class Bicycle_order {

	/**
	 * 供应商id
	 */
	private Long order_id;
	/**
	 * 主单编号
	 */
	private String order_code;
	/**
	 * 供应商id
	 */
	private Long vender_id;
	/**
	 * 购买日期
	 */
	private String buy_date;
	/**
	 * 购买数量
	 */
	private Double buy_num;
	/**
	 * 购买价格
	 */
	private Double buy_price;
	/**
	 * 负责人
	 */
	private String person_in_charge;
	/**
	 * 发票单号
	 */
	private String invoice_no;
	/**
	 * 经办人id
	 */
	private Integer user_id;
	/**
	 * 操作日期
	 */
	private String operator_time;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 获得采购单id
	 * @return
	 */
	public Long getOrder_id() {
		return order_id;
	}
	/**
	 * 设置采购单id
	 * @param order_id
	 */
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	/**
	 * 获得采购单号
	 * @return
	 */
	public String getOrder_code() {
		return order_code;
	}
	/**
	 * 设置采购单号
	 * @param order_code
	 */
	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}
	/**
	 * 获得供应商id
	 * @return
	 */
	public Long getVender_id() {
		return vender_id;
	}
	/**
	 * 设置供应商id
	 * @param vender_id
	 */
	public void setVender_id(Long vender_id) {
		this.vender_id = vender_id;
	}
	/**
	 * 获得采购日期
	 * @return
	 */
	public String getBuy_date() {
		return buy_date;
	}
	/**
	 * 设置采购日期
	 * @param buy_date
	 */
	public void setBuy_date(String buy_date) {
		this.buy_date = buy_date;
	}
	/**
	 * 获得购买数量s
	 * @return
	 */
	public Double getBuy_num() {
		return buy_num;
	}
	/**
	 * 设置购买数量
	 * @param buy_num
	 */
	public void setBuy_num(Double buy_num) {
		this.buy_num = buy_num;
	}
	/**
	 * 获得购买价格
	 * @return
	 */
	public Double getBuy_price() {
		return buy_price;
	}
	/**
	 * 设置购买价格
	 * @param buy_price
	 */
	public void setBuy_price(Double buy_price) {
		this.buy_price = buy_price;
	}
	/**
	 * 获得负责人
	 * @return
	 */
	public String getPerson_in_charge() {
		return person_in_charge;
	}
	/**
	 * 设置负责人
	 * @param person_in_charge
	 */
	public void setPerson_in_charge(String person_in_charge) {
		this.person_in_charge = person_in_charge;
	}
	/**
	 * 获得发票代码
	 * @return
	 */
	public String getInvoice_no() {
		return invoice_no;
	}
	/**
	 * 设置发票码
	 * @param invoice_no
	 */
	public void setInvoice_no(String invoice_no) {
		this.invoice_no = invoice_no;
	}
	/**
	 * 获得经办人id
	 * @return
	 */
	public Integer getUser_id() {
		return user_id;
	}
	/**
	 * 设置经办人id
	 * @param user_id
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	/**
	 * 获得操作日期
	 * @return
	 */
	public String getOperator_time() {
		return operator_time;
	}
	/**
	 * 设置操作日期
	 * @param operator_time
	 */
	public void setOperator_time(String operator_time) {
		this.operator_time = operator_time;
	}
	/**
	 * 获得备注
	 * @return
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置备注
	 * @param remark
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Bicycle_order [order_id=" + order_id + ", order_code=" + order_code + ", vender_id=" + vender_id
				+ ", buy_date=" + buy_date + ", buy_num=" + buy_num + ", buy_price=" + buy_price + ", person_in_charge="
				+ person_in_charge + ", invoice_no=" + invoice_no + ", user_id=" + user_id + ", operator_time="
				+ operator_time + ", remark=" + remark + "]";
	}
}
