package com.minifly.bean;
/**
 * 基类
 * @author xiaofei.he
 *
 */
public class BaseBean {
	
	private String code = "0";
	private String msg = "success";
	private Object data = "";
	
	
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	@Override
	public String toString() {
		return "{\"code\":\"" + code + "\", \"data\":\"" + data + "\", \"msg\":\"" + msg
				+ "\"}";
	}
	
	
}
