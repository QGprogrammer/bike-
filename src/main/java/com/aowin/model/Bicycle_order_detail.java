package com.aowin.model;

import java.util.List;

/**
 * 车辆采购明细单
 * @author Peter
 *
 */
public class Bicycle_order_detail {
	/**
	 * 采购明细单id
	 */
	private Long detail_id;
	/**
	 * 车类型id
	 */
	private Long catagory_id;
	/**
	 * 主单id
	 */
	private Long order_id;
	/**
	 * 新车list
	 */
	private List<Bicycle_info> bicycle_infoList;
	/**
	 * 出厂日期
	 */
	private String create_date;
	/**
	 * 批次号
	 */
	private String batch_no;
	/**
	 * 单价
	 */
	private Double price;
	/**
	 * 备注
	 */
	private String remark;
	public Long getDetail_id() {
		return detail_id;
	}
	public void setDetail_id(Long detail_id) {
		this.detail_id = detail_id;
	}
	public Long getcatagory_id() {
		return catagory_id;
	}
	public void setcatagory_id(Long catagory_id) {
		this.catagory_id = catagory_id;
	}
	public Long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}
	public List<Bicycle_info> getBicycle_infoList() {
		return bicycle_infoList;
	}
	public void setBicycle_infoList(List<Bicycle_info> bicycle_infoList) {
		this.bicycle_infoList = bicycle_infoList;
	}
	public String getCreate_date() {
		return create_date;
	}
	public void setCreate_date(String create_date) {
		this.create_date = create_date;
	}
	public String getBatch_no() {
		return batch_no;
	}
	public void setBatch_no(String batch_no) {
		this.batch_no = batch_no;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "Bicycle_order_detail [detail_id=" + detail_id + ", catagory_id=" + catagory_id + ", order_id="
				+ order_id + ", bicycle_infoList=" + bicycle_infoList + ", create_date=" + create_date + ", batch_no=" + batch_no
				+ ", price=" + price + ", remark=" + remark + "]";
	}	
}
