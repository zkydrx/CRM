package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.CustomerService;


/**
 * ???????Dao???
 * @author Administrator
 *
 */
public interface CustomerServiceDao {

	/**
	 * ??????????
	 * @param map
	 * @return
	 */
	public List<CustomerService> findCustomerService(Map<String, Object> map);
	
	/**
	 * ??????????????
	 * @param map
	 * @return
	 */
	public Long getTotalCustomerService(Map<String, Object> map);
	
	/**
	 * ?????????
	 * @param customerService
	 * @return
	 */
	public int addCustomerService(CustomerService customerService);
	
	/**
	 * ?????????
	 * @param customerService
	 * @return
	 */
	public int updateCustomerService(CustomerService customerService);
	
	/**
	 * ??????????
	 * @param id
	 * @return
	 */
	public int deleteCustomerService(Integer id);
	
	/**
	 * ???ID???????
	 * @param id
	 * @return
	 */
	public CustomerService findById(Integer id);
	
	
}
