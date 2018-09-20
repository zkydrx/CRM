package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.OrderDetails;

/**
 * ???????Service???
 * @author Administrator
 *
 */
public interface OrderDetailsService {

	/**
	 * ??????????
	 * @param map
	 * @return
	 */
	public List<OrderDetails> findOrderDetails(Map<String, Object> map);
	
	/**
	 * ???????????????
	 * @param map
	 * @return
	 */
	public Long getTotalOrderDetails(Map<String, Object> map);
	
	/**
	 * ????????????
	 * @param orderId
	 * @return
	 */
	public float getTotalPriceByOrderId(int orderId);
}
