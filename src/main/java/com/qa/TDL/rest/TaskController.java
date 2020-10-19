package com.qa.TDL.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.TDL.domain.Task;
import com.qa.TDL.service.TaskService;



@RestController
public class TaskController {
	
	private TaskService service;
	
	
	
	public TaskController(TaskService service) {
		super();
		this.service = service;
	}
	
	//Get request
	@GetMapping("/get")
	public List<Task> getTask() {
		return this.service.getTask();
		
	}
	
	@PostMapping("/create")
	public void createTask(@RequestBody Task task) {
		this.service.createTask(task);
	}
	
	@PutMapping("/update")
	public void updateTask(@RequestBody Task task, @PathParam("id") int id) {
		this.service.updateTask(task, id);
		//this.TaskDB.add(id, task);
	}
	
	@DeleteMapping("/remove/{id}")
	public void deleteTask(@PathVariable int id) {
		this.service.deleteTask(id);
	}

}
