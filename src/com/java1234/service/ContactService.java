package com.java1234.service;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Contact;

/**
 * ???????Service???
 * @author Administrator
 *
 */
public interface ContactService {

	/**
	 * ??????????
	 * @param map
	 * @return
	 */
	public List<Contact> findContact(Map<String, Object> map);
	
	/**
	 * ???????????????
	 * @param map
	 * @return
	 */
	public Long getTotalContact(Map<String, Object> map);
	
	/**
	 * ?????????
	 * @param contact
	 * @return
	 */
	public int addContact(Contact contact);
	
	/**
	 * ?????????
	 * @param contact
	 * @return
	 */
	public int updateContact(Contact contact);
	
	/**
	 * ??????????
	 * @param id
	 * @return
	 */
	public int deleteContact(Integer id);
	
	/**
	 * ???id???????
	 * @param id
	 * @return
	 */
	public Contact findById(Integer id);
}
