package com.qa.TDL.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue
	private long id;
	
	private String task;
	
	private String location;
	
	private long date;
	
	public Task(long id, String task, String location, long date) {
		super();
		this.id = id;
		this.task = task;
		this.location = location;
		this.date = date;
	}
	
	// REQUIRED
	public Task() { 
		super();

	}
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", task=" + task + ", location=" + location + ", date=" + date + "]";
	}
	
	// REQUIRED
	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


}
