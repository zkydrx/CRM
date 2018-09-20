package com.java1234.service;

import com.java1234.entity.User;

import java.util.List;
import java.util.Map;

/**
 * ???Service???
 * @author Administrator
 *
 */
public interface UserService {

	/**
	 * ??????
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	/**
	 * ??????
	 * @param map
	 * @return
	 */
	public List<User> findUser(Map<String, Object> map);
	
	/**
	 * ???????????
	 * @param map
	 * @return
	 */
	public Long getTotalUser(Map<String, Object> map);
	
	/**
	 * ???????
	 * @param user
	 * @return
	 */
	public int updateUser(User user);
	
	/**
	 * ??????
	 * @param user
	 * @return
	 */
	public int addUser(User user);
	
	/**
	 * ??????
	 * @param id
	 * @return
	 */
	public int deleteUser(Integer id);
}
