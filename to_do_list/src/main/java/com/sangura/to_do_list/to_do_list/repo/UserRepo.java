package com.sangura.to_do_list.to_do_list.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sangura.to_do_list.to_do_list.entities.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	Boolean existsByUserName(String userName);
	
}
