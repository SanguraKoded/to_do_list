package com.sangura.to_do_list.to_do_list.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sangura.to_do_list.to_do_list.entities.Tasks;
import com.sangura.to_do_list.to_do_list.priority.PriorityEnum;
import com.sangura.to_do_list.to_do_list.priority.StatusEnum;

public interface TasksRepo extends JpaRepository<Tasks, Integer> {

	List<Tasks> findByPriority(PriorityEnum priority);
	
	List<Tasks> findByStatus(StatusEnum status);
	
	List<Tasks> findByDueDate(LocalDate dueDate);

}
