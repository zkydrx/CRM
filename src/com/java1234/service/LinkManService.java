package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.LinkMan;

/**
 * ?????Service???
 * @author Administrator
 *
 */
public interface LinkManService {

	/**
	 * ????????
	 * @param map
	 * @return
	 */
	public List<LinkMan> findLinkMan(Map<String, Object> map);
	
	/**
	 * ????????????
	 * @param map
	 * @return
	 */
	public Long getTotalLinkMan(Map<String, Object> map);
	
	/**
	 * ????????
	 * @param linkMan
	 * @return
	 */
	public int addLinkMan(LinkMan linkMan);
	
	/**
	 * ????????
	 * @param linkMan
	 * @return
	 */
	public int updateLinkMan(LinkMan linkMan);
	
	/**
	 * ????????
	 * @param id
	 * @return
	 */
	public int deleteLinkMan(Integer id);
	
	/**
	 * ???id???????
	 * @param id
	 * @return
	 */
	public LinkMan findById(Integer id);
}
