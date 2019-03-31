package com.hockeyforum.hockeyforum.controllers;

import java.util.Collection;

import javax.annotation.Resource;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hockeyforum.hockeyforum.models.Category;
import com.hockeyforum.hockeyforum.models.Comment;
import com.hockeyforum.hockeyforum.models.Post;
import com.hockeyforum.hockeyforum.repositories.CategoryRepository;
import com.hockeyforum.hockeyforum.repositories.PostRepository;


@RestController
public class CommentController {
	
	@Resource
	PostRepository postRepo;
	@Resource
	CategoryRepository catRepo;
	
	@DeleteMapping("/comment/delete/{id}")
	public Collection<Category> deleteComment(@PathVariable Long id) {
		postRepo.deleteById(id);
		return (Collection<Category>) catRepo.findAll();
	}
	
	@PostMapping("/comment/add/{id}")
	public Collection<Category> addComment(@PathVariable Long id, @RequestBody String body) throws JSONException {
		JSONObject json = new JSONObject(body);
		String commentContent = json.getString("commentContent");
		Comment comment = new Comment(commentContent);
		Post post = postRepo.findById(id).get();
		post.addComment(comment);
		postRepo.save(post);
		return (Collection<Category>) catRepo.findAll();
	}
	
}
