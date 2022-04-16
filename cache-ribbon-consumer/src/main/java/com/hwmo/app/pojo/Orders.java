package com.hwmo.app.pojo;

import java.io.Serializable;

/**
 * @author mhw
 *
 */
public class Orders implements Serializable{

	private Integer id;
	private String remark;
	private Integer total;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
}
