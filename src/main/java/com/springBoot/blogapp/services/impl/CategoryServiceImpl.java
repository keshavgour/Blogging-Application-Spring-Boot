package com.springBoot.blogapp.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.blogapp.entities.Category;
import com.springBoot.blogapp.exceptions.ResourceNotFoundException;
import com.springBoot.blogapp.payloads.CategoryDto;
import com.springBoot.blogapp.repositories.CategoryRepo;
import com.springBoot.blogapp.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		
	Category cat = this.modelMapper.map(categoryDto, Category.class);
	Category addedCat = this.categoryRepo.save(cat);
     return  this.modelMapper.map(addedCat, CategoryDto.class);
	
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		
		Category cat = this.categoryRepo.findById(categoryId)
		.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		
		    cat.setCategoryTitle(categoryDto.getCategoryTitle());
		    cat.setCategoryDescription(categoryDto.getCategoryDescription());
		    
		   Category updatedCat = this.categoryRepo.save(cat);
		   	return this.modelMapper.map(updatedCat, CategoryDto.class);
	
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		 	Category cat = this.categoryRepo.findById(categoryId)
		 			.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId));
		 		this.categoryRepo.delete(cat);
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		
		Category cat  = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "CategoryId", categoryId) );
		
		
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		 List<Category> categories = this.categoryRepo.findAll();
		 List<CategoryDto> categoryDtos = categories.stream().map((category) -> this.modelMapper.map(category, CategoryDto.class) )
				 .collect(Collectors.toList());
		
		 
		return categoryDtos;
	}

}
