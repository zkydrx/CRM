package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Customer;
import com.java1234.entity.CustomerFw;
import com.java1234.entity.CustomerGc;
import com.java1234.entity.CustomerGx;

/**
 * ???Service???
 * @author Administrator
 *
 */
public interface CustomerService {

	/**
	 * ??????
	 * @param map
	 * @return
	 */
	public List<Customer> findCustomer(Map<String, Object> map);
	
	/**
	 * ???????????
	 * @param map
	 * @return
	 */
	public Long getTotalCustomer(Map<String, Object> map);
	
	/**
	 * ?????
	 * @param customer
	 * @return
	 */
	public int addCustomer(Customer customer);
	
	/**
	 * ?????
	 * @param customer
	 * @return
	 */
	public int updateCustomer(Customer customer);
	
	/**
	 * ??????
	 * @param id
	 * @return
	 */
	public int deleteCustomer(Integer id);
	
	/**
	 * ???Id???????
	 * @param id
	 * @return
	 */
	public Customer findById(Integer id);
	
	/**
	 * ??????????????????????????????
	 */
	public void checkCustomerLoss();
	
	/**
	 * ??????????
	 * @param map
	 * @return
	 */
	public List<CustomerGx> findCutomerGx(Map<String, Object> map);
	
	/**
	 * ??????????????
	 * @param map
	 * @return
	 */
	public Long getTotalCustomerGx(Map<String, Object> map);
	
	/**
	 * ??????????
	 * @return
	 */
	public List<CustomerGc> findCustomerGc();
	
	/**
	 * ?????????????
	 * @return
	 */
	public List<CustomerFw> findCustomerFw();
}
