package com.hockeyforum.hockeyforum.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hockeyforum.hockeyforum.models.Category;
import com.hockeyforum.hockeyforum.repositories.CategoryRepository;

@RestController
public class CategoryController {

	@Resource
	CategoryRepository categoryRepo;
	
	@GetMapping("/categories")
	public Collection<Category> getCategories() {
		return (Collection<Category>) categoryRepo.findAll();
	}
}
