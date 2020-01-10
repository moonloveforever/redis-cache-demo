package com.zhaoxl.redisdemo.pub.web;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Maps;

import java.io.Serializable;
import java.util.Map;

public class Result implements Serializable {

	private static final long serialVersionUID = -1206732821700623440L;

	private Map<String, Object> data;

	private Status status;

	private int errorNo;

	private String errorMsg;

	private Result() {
		this(Status.OK);
	}

	public static Result instance() {
		return new Result();
	}

	public static Result instance(Status status) {
		return new Result(status);
	}

	private Result(Status status) {
		this.status = status;
		this.data = Maps.newHashMap();
	}

	@JsonIgnore
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public Result add(String key, Object value) {
		this.data.put(key, value);
		return this;
	}

	public Result addAll(Map<String, ?> map) {
		this.data.putAll(map);
		return this;
	}

	public Result remove(String key) {
		this.data.remove(key);
		return this;
	}

	public int getRetCode() {
		return this.status.getRetCode();
	}

	public String getRetMsg() {
		return this.status.getRetMsg();
	}

	public Result(int errorNo, String errorMsg) {
		this.errorNo = errorNo;
		this.errorMsg = errorMsg;
	}

}