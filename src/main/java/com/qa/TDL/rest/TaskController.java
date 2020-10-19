package com.qa.TDL.rest;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Task>> getTask() {
		return ResponseEntity.ok(this.service.getTask());
		
	}
	
	@PostMapping("/create")
	public ResponseEntity<Task> createTask(@RequestBody Task task) {
		return new ResponseEntity<Task>(this.service.createTask(task), HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Task> updateTask(@RequestBody Task task, @PathParam("id") int id) {
		return new ResponseEntity<Task>(this.service.updateTask(task, id), HttpStatus.ACCEPTED);
		
	}
	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Object> deleteTask(@PathVariable long id) {
		if (this.service.deleteTask(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
