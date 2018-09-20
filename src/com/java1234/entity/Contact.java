package com.java1234.entity;

import java.util.Date;

/**
 * ???????
 * @author Administrator
 *
 */
public class Contact {

	private Integer id; // ???
	private Customer customer; // ???????
	private Date contactTime; // ???????
	private String address; // ???????
	private String overView; // ???
	
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
	public Date getContactTime() {
		return contactTime;
	}
	public void setContactTime(Date contactTime) {
		this.contactTime = contactTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getOverView() {
		return overView;
	}
	public void setOverView(String overView) {
		this.overView = overView;
	}
	
	
}
