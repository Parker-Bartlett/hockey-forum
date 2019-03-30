package com.hockeyforum.hockeyforum;

import javax.annotation.Resource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import com.hockeyforum.hockeyforum.models.Category;
import com.hockeyforum.hockeyforum.models.Comment;
import com.hockeyforum.hockeyforum.models.Post;
import com.hockeyforum.hockeyforum.repositories.CategoryRepository;
import com.hockeyforum.hockeyforum.repositories.PostRepository;

@Service
public class Initializer implements CommandLineRunner {

	@Resource
	CategoryRepository categoryRepo;

	@Resource
	PostRepository postRepo;


	@Override
	public void run(String... args) throws Exception {
		Category devils = categoryRepo.save(new Category("New Jersey Devils"));
		Category wings = categoryRepo.save(new Category("Detroit Red Wings"));
		Category rangers = categoryRepo.save(new Category("New York Rangers"));

		Post post1 = postRepo.save(new Post("Rangers Suck!", "What's the deal with the Rangers?", rangers));
		Post post2 = postRepo.save(new Post("Red Wings Suck!", "What's the deal with the Red Wings?", wings));
		Post post3 = postRepo.save(new Post("Devils Suck!", "What's the deal with the Devils?", devils));
		
//		commentRepo.save(new Comment(post1, "You are right!"));
//		commentRepo.save(new Comment(post2, "You are wrong!"));
//		commentRepo.save(new Comment(post3, "You suck!"));
		
		Comment comment1 = new Comment("Cool stuff");
		Comment comment2 = new Comment("Awful stuff");
		Comment comment3 = new Comment("Decent stuff");
		
		post1.addComment(comment1);
		post2.addComment(comment2);
		post3.addComment(comment3);
		
		postRepo.save(post1);
		postRepo.save(post2);
		postRepo.save(post3);

		
	}
}
