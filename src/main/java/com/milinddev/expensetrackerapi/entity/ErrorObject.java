package com.milinddev.expensetrackerapi.entity;

import java.util.Date;

import lombok.Data;

@Data
public class ErrorObject {
	private Integer statuscode;
	private String message;
	public Integer getStatuscode() {
		return statuscode;
	}
	public void setStatuscode(Integer statuscode) {
		this.statuscode = statuscode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	private Date timestamp;
	
}
