package com.java1234.entity;

import java.util.Date;

/**
 * ???????
 * @author Administrator
 *
 */
public class Order {

	private Integer id; // ???
	private Customer customer; // ???????
	private String orderNo; // ??????
	private Date orderDate; // ????????
	private String address; // ??????
	private int state; // ?? 0 ¦Ä??? 2 ????
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	
}
