package com.java1234.dao;

import com.java1234.entity.User;

import java.util.List;
import java.util.Map;

/**
 * ???Dao???
 * @author Administrator
 *
 */
public interface UserDao {

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
