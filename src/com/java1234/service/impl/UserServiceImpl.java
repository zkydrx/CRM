package com.java1234.service.impl;

import com.java1234.dao.UserDao;
import com.java1234.entity.User;
import com.java1234.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * ???Service?????
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;
	
	@Override
	public User login(User user) {
		return userDao.login(user);
	}

	@Override
	public List<User> findUser(Map<String, Object> map) {
		return userDao.findUser(map);
	}

	@Override
	public int updateUser(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public Long getTotalUser(Map<String, Object> map) {
		return userDao.getTotalUser(map);
	}

	@Override
	public int addUser(User user) {
		return userDao.addUser(user);
	}

	@Override
	public int deleteUser(Integer id) {
		return userDao.deleteUser(id);
	}

}
