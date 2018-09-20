package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Order;

/**
 * ????service???
 * @author Administrator
 *
 */
public interface OrderService {

	/**
	 * ???????
	 * @param map
	 * @return
	 */
	public List<Order> findOrder(Map<String, Object> map);
	
	/**
	 * ????????????
	 * @param map
	 * @return
	 */
	public Long getTotalOrder(Map<String, Object> map);
	
	/**
	 * ???Id???????
	 * @param id
	 * @return
	 */
	public Order findById(Integer id);
}
