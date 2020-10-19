package com.qa.TDL.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.qa.TDL.domain.Task;
import com.qa.TDL.domain.TaskRepo;

@Service
public class TaskService {
	
	private TaskRepo repo;
	
	
	public TaskService (TaskRepo repo) {
		super();
		this.repo = repo;
	}


	public void setRepo(TaskRepo repo) {
		this.repo = repo;
	}


	//Get request
	public List<Task> getTask() {
		return this.repo.findAll();
		
	}
	
	
	public void createTask(Task task) {
		this.repo.save(task);
	}
	
	
	public void updateTask(Task task, long id) {
		Task oldTask = this.repo.findById(id).get();
		oldTask.setTask(task.getTask());
		oldTask.setLocation(task.getLocation());
		oldTask.setDate(task.getDate());
		
		this.repo.save(oldTask);
	}
	
	
	public void deleteTask(long id) {
		this.repo.deleteById(id);
	}


}
