package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.LinkMan;

/**
 * ?????Dao???
 * @author Administrator
 *
 */
public interface LinkManDao {

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
