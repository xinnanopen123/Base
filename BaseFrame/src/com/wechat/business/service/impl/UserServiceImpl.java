package com.wechat.business.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wechat.business.bean.User;
import com.wechat.business.common.Page;
import com.wechat.business.dao.IUserDao;
import com.wechat.business.service.IUserService;
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao iUserDao;
	
	@Override
	public List<User> queryAll() {
		return iUserDao.queryAll();
	}
	
	public List<User> queryByPage() {
		Page page = new Page();
		page.setCurrentPage(0);
		page.setPageCount(5);
		page.setTotalPage(20);
		page.setTotalNumber(100);
		page.setOrderType(Page.DESC);
		String[] colums = {"id"};
		page.setOrderColums(colums);
		List<User> userList = iUserDao.queryByPage(page);
		return userList;
	}
	
	@Override
	public User queryById() {
		return (User) iUserDao.queryById();
	}

	@Transactional
	public boolean addUser(User user) {
		boolean isSuccess = false;
		int affectRows = iUserDao.add(user);
		if(affectRows>0){
			isSuccess=true;
		}
		return isSuccess;
	}

	public boolean update(User user) {
		boolean isSuccess = false;
		int affectRows = iUserDao.update(user);
		if(affectRows>0){
			isSuccess=true;
		}
		return isSuccess;
	}

	public boolean delete(int id) {
		boolean isSuccess = false;
		int affectRows = iUserDao.delete(id);
		if(affectRows>0){
			isSuccess=true;
		}
		return isSuccess;
	}
	
}
