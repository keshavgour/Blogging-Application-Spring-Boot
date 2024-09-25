package com.springBoot.blogapp.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.blogapp.entities.Comment;
import com.springBoot.blogapp.entities.Post;
import com.springBoot.blogapp.exceptions.ResourceNotFoundException;
import com.springBoot.blogapp.payloads.CommentDto;
import com.springBoot.blogapp.repositories.CommentRepo;
import com.springBoot.blogapp.repositories.PostRepo;
import com.springBoot.blogapp.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CommentRepo commentRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
			
			 Post post = this.postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "Post Id", postId));
			
			 		Comment comment = this.modelMapper.map(commentDto, Comment.class);
			 		comment.setPost(post);
			 		
			 		Comment savedComment = this.commentRepo.save(comment);
			 		
			 		return this.modelMapper.map(savedComment, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
			
			Comment comment = this.commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("Comment", "comment Id", commentId));
				this.commentRepo.delete(comment);
	}

}
