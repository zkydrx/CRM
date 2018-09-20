package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Product;

/**
 * ???Dao???
 * @author Administrator
 *
 */
public interface ProductDao {

	/**
	 * ??????
	 * @param map
	 * @return
	 */
	public List<Product> findProduct(Map<String, Object> map);
	
	/**
	 * ???????????
	 * @param map
	 * @return
	 */
	public Long getTotalProduct(Map<String, Object> map);
	
	
}
