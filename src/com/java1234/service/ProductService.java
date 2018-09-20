package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Product;

/**
 * ???Dao???
 * @author Administrator
 *
 */
public interface ProductService {

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
