package com.sangura.to_do_list.to_do_list.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sangura.to_do_list.to_do_list.priority.PriorityEnum;
import com.sangura.to_do_list.to_do_list.priority.StatusEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Tasks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull(message = "Task description cannot be null")
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@NotNull(message = "User cannot be null")
	@JsonBackReference
	private User user;
	
	@NotNull(message = "Date created cannot be null")
	@PastOrPresent(message = "Date created cannot be future")
	private LocalDate dateCreated;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Priority cannot be null")
	private PriorityEnum priority;
	
	@Enumerated(EnumType.STRING)
	@NotNull(message = "Status cannot be null")
	private StatusEnum status;
	
	@NotNull(message = "Due date cannot be null")
	@FutureOrPresent(message = "Due date cannot be past")
	private LocalDate dueDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}

	public PriorityEnum getPriority() {
		return priority;
	}

	public void setPriority(PriorityEnum priority) {
		this.priority = priority;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public String toString() {
		return "Tasks [id=" + id + ", description=" + description + ", user=" + user + ", dateCreated=" + dateCreated
				+ ", priority=" + priority + ", status=" + status + ", dueDate=" + dueDate + ", getId()=" + getId()
				+ ", getDescription()=" + getDescription() + ", getUser()=" + getUser() + ", getDateCreated()="
				+ getDateCreated() + ", getPriority()=" + getPriority() + ", getStatus()=" + getStatus()
				+ ", getDueDate()=" + getDueDate() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
}
