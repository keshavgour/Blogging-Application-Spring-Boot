package com.springBoot.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.blogapp.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
