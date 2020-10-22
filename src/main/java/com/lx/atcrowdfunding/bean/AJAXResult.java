package com.lx.atcrowdfunding.bean;

public class AJAXResult {
	
	private boolean success;
	private Object data;
	
	public AJAXResult() {}
	public AJAXResult(boolean success) {
		super();
		this.success = success;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	

}
