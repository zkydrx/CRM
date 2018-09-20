package com.java1234.service;

import java.util.List;
import java.util.Map;
import com.java1234.entity.CustomerService;

/**
 * ???????Service???
 * @author Administrator
 *
 */
public interface CustomerServiceService {

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
