package com.wechat.business.dao.base;

import java.io.Serializable;
import java.util.List;

import com.wechat.business.common.Page;

public interface IBaseDao<T,ID extends Serializable> {

	/**
	 * 查询全部数据
	 * @return 返回数据集合list
	 */
	public List<T> queryAll();
	
	/**
	 * 分页查询
	 * @param page 分页条件
	 * @return 返回分页数据
	 */
	public List<T> queryByPage(Page page);
	
	
	/**
	 * 根据id查询
	 * @return 返回单条数据
	 */
	public T queryById();
	
	/**
	 * 添加数据
	 * @param 单条数据
	 * @return id(新增数据的id) 
	 */
	public int add(T obj);
	
	/**
	 * 更新数据
	 * @param 单条数据信息
	 * @return boolean 是否更新成功
	 */
	public int update(T obj);
	
	/**
	 * 删除数据
	 * @param 数据id
	 * @return boolean 是否删除成功
	 */
	public int delete(int id);
}
