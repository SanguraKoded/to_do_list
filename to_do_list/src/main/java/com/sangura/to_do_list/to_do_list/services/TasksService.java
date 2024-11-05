package com.sangura.to_do_list.to_do_list.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sangura.to_do_list.to_do_list.entities.Tasks;
import com.sangura.to_do_list.to_do_list.exceptions.InvalidPriorityException;
import com.sangura.to_do_list.to_do_list.exceptions.InvalidStatusException;
import com.sangura.to_do_list.to_do_list.exceptions.ResourceNotFoundException;
import com.sangura.to_do_list.to_do_list.priority.PriorityEnum;
import com.sangura.to_do_list.to_do_list.priority.StatusEnum;
import com.sangura.to_do_list.to_do_list.repo.TasksRepo;


@Service
public class TasksService {
	
	@Autowired
	TasksRepo tasksRepo;

	public List<Tasks> getAllTasks(){
		
		return tasksRepo.findAll();
		
	}
	
	public Tasks createTask(Tasks task) {
		try {
			PriorityEnum userPriority = task.getPriority();
			String newPriority = userPriority.toString();
			PriorityEnum.formString(newPriority);
			try {
				StatusEnum userStatus  =task.getStatus();
				String newStatus = userStatus.toString();
				StatusEnum.formString(newStatus);
			}
			catch(InvalidStatusException e) {
				throw new InvalidStatusException(e.getMessage());
			}
		}
		
		catch (InvalidPriorityException e) {
			throw new InvalidPriorityException(e.getMessage());
		}
		
		return tasksRepo.save(task);
	}
	
	public Tasks findTaskById(int id) {
		return tasksRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException ("Given Task Id is incorrect"));
			
	}
	
	public Tasks updateTaskById(int id, Tasks task) {
		tasksRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Given Task Id is incorrect"));
		try {
			PriorityEnum userPriority = task.getPriority();
			String newPriority = userPriority.toString();
			PriorityEnum.formString(newPriority);
			try {
				StatusEnum userStatus  =task.getStatus();
				String newStatus = userStatus.toString();
				StatusEnum.formString(newStatus);
			}
			catch(InvalidStatusException e) {
				throw new InvalidStatusException(e.getMessage());
			}
		}
		
		catch (InvalidPriorityException e) {
			throw new InvalidPriorityException(e.getMessage());
		}
		
		return tasksRepo.save(task);
		
	}
	
	public void deleteTaskById(int id) {
		tasksRepo.findById(id).orElseThrow(() -> new RuntimeException("Given Id is incorrect"));
		tasksRepo.deleteById(id);
	}
	
	public List<Tasks> tasksByPriority(PriorityEnum priority){
		return tasksRepo.findByPriority(priority);
	}
	
	public List<Tasks> tasksByStatus(StatusEnum status){
		return tasksRepo.findByStatus(status);
	}
	
	public List<Tasks> tasksByDueDate(LocalDate dueDate){
		return tasksRepo.findByDueDate(dueDate);
	}
	
	public Tasks closeTaskById(int id) {
		Tasks task = tasksRepo.findById(id).orElseThrow(() -> new RuntimeException("Given Id is incorrect"));
		task.setStatus(StatusEnum.COMPLETED);
		return tasksRepo.save(task);
	}

}
