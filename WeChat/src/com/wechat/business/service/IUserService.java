package com.wechat.business.service;

import java.util.List;

import com.wechat.business.bean.User;

public interface IUserService {

	public List<User> queryAll();
	
	public User queryById();
	
	public boolean addUser(User user) throws Exception;
	
	public boolean update(User user);
	
	public boolean delete(int id);
	
	public List<User> queryByPage();
}
