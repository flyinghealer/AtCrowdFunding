package com.lx.atcrowdfunding.bean;

import java.util.List;

import org.apache.poi.ss.formula.functions.T;

public class Page<T> {
	
	private List<T> datas;
	private int pageno;
	private int totalno;
	private int totalsize;
	
	public Page() {}
	public Page(List<T> datas, int pageno, int totalno, int totalsize) {
		super();
		this.datas = datas;
		this.pageno = pageno;
		this.totalno = totalno;
		this.totalsize = totalsize;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public int getPageno() {
		return pageno;
	}
	public void setPageno(int pageno) {
		this.pageno = pageno;
	}
	public int getTotalno() {
		return totalno;
	}
	public void setTotalno(int totalno) {
		this.totalno = totalno;
	}
	public int getTotalsize() {
		return totalsize;
	}
	public void setTotalsize(int totalsize) {
		this.totalsize = totalsize;
	}
	
	

}
