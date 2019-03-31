package com.hockeyforum.hockeyforum.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@PostMapping("/category/update/title/{id}")
	public Collection<Category> updateCategoryTitle(@PathVariable Long id, @RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String title = json.getString("title");
		Category cat = categoryRepo.findById(id).get();
		cat.setTitle(title);
		categoryRepo.save(cat);
		return (Collection<Category>) categoryRepo.findAll();
	}
	
}
