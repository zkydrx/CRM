package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.CustomerLoss;

/**
 * ??????Dao???
 * @author Administrator
 *
 */
public interface CustomerLossDao {

	/**
	 * ?????????????
	 * @param map
	 * @return
	 */
	public List<CustomerLoss> findCustomerLoss(Map<String, Object> map);
	
	/**
	 * ??????????????
	 * @param map
	 * @return
	 */
	public Long getTotalCutomerLoss(Map<String, Object> map);
	
	/**
	 * ???Id???????
	 * @param id
	 * @return
	 */
	public CustomerLoss findById(Integer id);
	
	/**
	 * ???????????
	 * @param customerLoss
	 * @return
	 */
	public int addCustomerLoss(CustomerLoss customerLoss);
	
	/**
	 * ???????????
	 * @param customerLoss
	 * @return
	 */
	public int updateCustomerLoss(CustomerLoss customerLoss);
	
}
