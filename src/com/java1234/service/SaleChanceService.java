package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.SaleChance;

/**
 * ???????Service
 * @author Administrator
 *
 */
public interface SaleChanceService {

	/**
	 * ??????????
	 * @param map
	 * @return
	 */
	public List<SaleChance> findSaleChance(Map<String, Object> map);
	
	/**
	 * ??????????????
	 * @param map
	 * @return
	 */
	public Long getTotalSaleChance(Map<String, Object> map);
	
	/**
	 * ??????????
	 * @param saleChance
	 */
	public int addSaleChance(SaleChance saleChance);
	
	/**
	 * ??????????
	 * @param saleChance
	 * @return
	 */
	public int updateSaleChance(SaleChance saleChance);
	
	/**
	 * ??????????
	 * @param id
	 * @return
	 */
	public int deleteSaleChance(Integer id);
	
	/**
	 * ???????????
	 * @param devResult
	 * @return
	 */
	public int updateSaleChanceDevResult(Map<String, Object> map);
	
	/**
	 * ???id???????
	 * @param id
	 * @return
	 */
	public SaleChance findById(Integer id);
}
