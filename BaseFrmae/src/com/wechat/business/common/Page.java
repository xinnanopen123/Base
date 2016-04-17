package com.wechat.business.common;

/**
 * 分页条件类
 */
public class Page {
	
	/**
	 * 当前页
	 */
	private int currentPage;
	/**
	 * 总条数
	 */
	private int totalNumber;
	/**
	 * 总页数
	 */
	private int totalPage;
	/**
	 * 每页的条数
	 */
	private int pageCount;
	/**
	 * 排序类型（升序、降序）
	 */
	private String orderType;
	public static final String DESC = "desc";
	public static final String ASC = "asc";
	/**
	 * 排序的字段值数组(用于赋值)
	 */
	private String[] orderColums;
	
	/**
	 * 拼接成 “A,B,C desc” 样子的字符串,用于sql
	 */
	private String orderSql;
	
	/**
	 * 拼接成 “limit 0,10” 样子的字符串，用于sql
	 */
	private String pageSql;
	
	public String getPageSql(){
		int start = (currentPage-1) * pageCount;
		pageSql = "limit "+start+","+pageCount;
		return pageSql;
	}
	
	public String getOrderSql() {
		for(int i=0;i<orderColums.length;i++){
			if(i==orderColums.length-1){
				orderSql = orderSql + orderColums[i];
			}else{
				orderSql = orderSql + orderColums[i] + ",";
			}
			orderSql += orderType;
		}
		return orderSql;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(int totalNumber) {
		this.totalNumber = totalNumber;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String[] getOrderColums() {
		return orderColums;
	}
	public void setOrderColums(String[] orderColums) {
		this.orderColums = orderColums;
	}

}
