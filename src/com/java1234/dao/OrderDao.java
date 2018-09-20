package com.java1234.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.java1234.entity.Order;

/**
 * ????Dao???
 * @author Administrator
 *
 */
public interface OrderDao {

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
	
	/**
	 * ????????????????????
	 * @param cusId
	 * @return
	 */
	public Order findLastByCusId(int cusId);
}
