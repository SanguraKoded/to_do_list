package com.sangura.to_do_list.to_do_list.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sangura.to_do_list.to_do_list.entities.Tasks;
import com.sangura.to_do_list.to_do_list.priority.PriorityEnum;
import com.sangura.to_do_list.to_do_list.priority.StatusEnum;
import com.sangura.to_do_list.to_do_list.services.TasksService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/tasks")
public class TasksController {
	
	@Autowired
	TasksService tasksService;
	
	@GetMapping
	public ResponseEntity<List<Tasks>> getAllTasks(){
		
		List<Tasks> tasks = tasksService.getAllTasks();
		return ResponseEntity.ok(tasks);
	}
	
	@PostMapping
	public ResponseEntity<Tasks> createTask(@RequestBody Tasks task){
		return ResponseEntity.status(HttpStatus.CREATED).body(tasksService.createTask(task));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Tasks> findTaskById(@PathVariable int id){
		return ResponseEntity.ok(tasksService.findTaskById(id));
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Tasks> updateTask(@PathVariable int id, @RequestBody Tasks task){
		return ResponseEntity.status(HttpStatus.CREATED).body(tasksService.updateTaskById(id, task));
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteTaskById(@PathVariable int id){
		tasksService.deleteTaskById(id);
		ResponseEntity.noContent().build();
		String message = "Task with Id " +id +" is successfully deleted";
		return ResponseEntity.ok(message);
	}
	
	@GetMapping("/byPriority/{priority}")
	public ResponseEntity<List<Tasks>> tasksByPriority(@PathVariable PriorityEnum priority){
		return ResponseEntity.ok(tasksService.tasksByPriority(priority));
	}
	
	@GetMapping("/byStatus/{status}")
	public ResponseEntity<List<Tasks>> tasksByStatus(@PathVariable StatusEnum status){
		return ResponseEntity.ok(tasksService.tasksByStatus(status));
	}

	@GetMapping("/byDueDate/{dueDate}")
	public ResponseEntity<List<Tasks>> tasksByDueDate(@Valid @PathVariable LocalDate dueDate){
		return ResponseEntity.ok(tasksService.tasksByDueDate(dueDate));
	}
	
	@PutMapping("/close/{id}")
	public ResponseEntity<Tasks> closeTaskById(@PathVariable int id){
		return ResponseEntity.ok(tasksService.closeTaskById(id));
	}
}
