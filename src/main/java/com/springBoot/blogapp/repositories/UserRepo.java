package com.springBoot.blogapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.blogapp.entities.User;
import java.util.List;


public interface UserRepo extends JpaRepository<User, Integer> {

		Optional<User> findByEmail(String email);
	
}
