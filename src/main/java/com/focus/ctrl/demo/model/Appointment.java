package com.focus.ctrl.demo.model;

import java.util.Date;

public class Appointment {
	private String name;
	private Date date;
	private String event;
	private String desc;
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String userName) {
		this.name = userName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
