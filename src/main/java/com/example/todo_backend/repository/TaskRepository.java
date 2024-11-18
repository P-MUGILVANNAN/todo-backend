package com.example.todo_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todo_backend.model.Task;

public interface TaskRepository extends JpaRepository<Task,Long> {
	
}