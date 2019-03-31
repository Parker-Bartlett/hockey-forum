package com.hockeyforum.hockeyforum.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hockeyforum.hockeyforum.models.Category;
import com.hockeyforum.hockeyforum.models.Post;
import com.hockeyforum.hockeyforum.repositories.CategoryRepository;

@RestController
public class CategoryController {

	@Resource
	CategoryRepository categoryRepo;
	
	
	@GetMapping("/categories")
	public Collection<Category> getCategories() {
		return (Collection<Category>) categoryRepo.findAll();
	}
	
	@GetMapping("/{id}/posts")
	public Collection<Post> getCategoriesPosts(@PathVariable Long id) {
		Category cat =categoryRepo.findById(id).get();
		return cat.getPosts();
	}
	
}
