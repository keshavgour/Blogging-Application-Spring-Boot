package com.springBoot.blogapp.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.springBoot.blogapp.entities.Category;
import com.springBoot.blogapp.entities.Comment;
import com.springBoot.blogapp.entities.User;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {

	private Integer postId;
	
	@NotBlank
	@Size(min = 5, message = "Title should be min of 5 chars")
	private String title;
	
	@NotBlank
	@Size(min = 10, message = "Content should be min of 10 chars")
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto> comments = new HashSet<>();
}
