package com.example.todo_backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.todo_backend.model.Task;
import com.example.todo_backend.repository.TaskRepository;


@RestController
@CrossOrigin
@RequestMapping("/api/tasks")
public class TaskController {
	
	@Autowired
	private TaskRepository taskRepository;
	
	@GetMapping("/home")
	public String hello() {
		return "Hello from server";
	}
	
	
//	@PostMapping("/api/tasks")
//	public List<String> createTask() {
//		List<String> users = new ArrayList<>();
//		users.add("Mugil");
//		users.add("Jaga");
//		users.add("Mugesh");
//		return users;
//	}
	
	@PostMapping
	public Task createTask(@RequestBody Task task){
		taskRepository.save(task);
		return task;
	}
	
	@GetMapping
	public List<Task> getAllTask() {
		return taskRepository.findAll();
	}
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
		task.setId(id);
		return taskRepository.save(task);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTask(@PathVariable Long id) {
		taskRepository.deleteById(id);
	}
	
}