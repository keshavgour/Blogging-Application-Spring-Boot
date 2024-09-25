package com.springBoot.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.blogapp.entities.Role;

public interface RoleRepo extends JpaRepository<Role, Integer> {

}
