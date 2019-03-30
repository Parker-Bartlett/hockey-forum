package com.hockeyforum.hockeyforum.models;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String body;
	
	@ElementCollection
	@CollectionTable
	private Collection<Comment> comments;
	
	@ManyToOne
	@JsonIgnore
	private Category category;
	
	public Post() {}
	
	public Post(String title, String body, Category category) {
		this.title = title;
		this.body = body;
		this.category = category;
		this.comments = new ArrayList<Comment>();
	}

	public Collection<Comment> getComment() {
		return comments;
	}
	
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getBody() {
		return body;
	}

	public Category getCategory() {
		return category;
	}
	
	public void addComment(Comment commentToAdd) {
		comments.add(commentToAdd);
	}
	
	
}
