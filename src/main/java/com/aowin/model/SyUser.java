package com.aowin.model;

/**
 * 用户类
 * @author Peter
 *
 */
public class SyUser {

	/**
	 * 用户id
	 */
	private Integer user_id;  
	/**
	 * 角色id
	 */
	private Integer role_id;
	/**
	 * 角色描述(联合查询)
	 */
	private String role_describe;
	/**
	 * 登录名
	 */
	private String login_name;
	/**
	 * 用户名
	 */
	private String username;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 激活标志
	 */
	private double active_flag;
	/**
	 * 注销标志
	 */
	private Integer zxbj;
	/**
	 * 办公电话
	 */
	private String office_phone;
	/**
	 * 个人电话
	 */
	private String mobile_phone;
	/**
	 * 电子邮件
	 */
	private String email;
	/**
	 * 分页页面
	 */
	private Integer pageNum;
	/**
	 * 获得用户id
	 * @return
	 */
	public Integer getUser_id() {
		return user_id;
	}
	/**
	 * 设置用户id
	 * @param user_id
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	/**
	 * 获得角色id
	 * @return
	 */
	public Integer getRole_id() {
		return role_id;
	}
	/**
	 * 设置角色id
	 * @param role_id
	 */
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	/**
	 * 获得登录名
	 * @return
	 */
	public String getLogin_name() {
		return login_name;
	}
	/**
	 * 设置登录名
	 * @param login_name
	 */
	public void setLogin_name(String login_name) {
		this.login_name = login_name;
	}
	/**
	 * 获得用户名
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置用户名
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获得密码
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置密码
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获得激活标志
	 * @return
	 */
	public double getActive_flag() {
		return active_flag;
	}
	/**
	 * 设置激活标志
	 * @param active_flag
	 */
	public void setActive_flag(double active_flag) {
		this.active_flag = active_flag;
	}
	/**
	 * 获得注销标志
	 * @return
	 */
	public Integer getZxbj() {
		return zxbj;
	}
	/**
	 * 设置注销标志
	 * @param zxbj
	 */
	public void setZxbj(Integer zxbj) {
		this.zxbj = zxbj;
	}
	/**
	 * 获得办公电话
	 * @return
	 */
	public String getOffice_phone() {
		return office_phone;
	}
	/**
	 * 设置办公电话
	 * @param office_phone
	 */
	public void setOffice_phone(String office_phone) {
		this.office_phone = office_phone;
	}
	/**
	 * 获得个人电话
	 * @return
	 */
	public String getMobile_phone() {
		return mobile_phone;
	}
	/**
	 * 设置个人电话
	 * @param mobile_phone
	 */
	public void setMobile_phone(String mobile_phone) {
		this.mobile_phone = mobile_phone;
	}
	/**
	 * 获得电子邮件
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置电子邮件
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取角色描述
	 * @return
	 */
	public String getRole_describe() {
		return role_describe;
	}
	/**
	 * 设置角色描述
	 * @param role_name
	 */
	public void setRole_describe(String role_describe) {
		this.role_describe = role_describe;
	}
	/**
	 * 获取分页页码
	 * @return
	 */
	public Integer getPageNum() {
		return pageNum;
	}
	/**
	 * 设置分页页码
	 * @param pageNum
	 */
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	@Override
	public String toString() {
		return "SyUser [user_id=" + user_id + ", role_id=" + role_id + ", role_describe=" + role_describe
				+ ", login_name=" + login_name + ", username=" + username + ", password=" + password + ", active_flag="
				+ active_flag + ", zxbj=" + zxbj + ", office_phone=" + office_phone + ", mobile_phone=" + mobile_phone
				+ ", email=" + email + ", pageNum=" + pageNum + "]";
	}
	
}
