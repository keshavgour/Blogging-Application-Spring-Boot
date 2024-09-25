package com.springBoot.blogapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.blogapp.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
