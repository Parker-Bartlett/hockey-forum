package com.hockeyforum.hockeyforum.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	private String body;
	
	@ManyToMany
	private Category category;
	@OneToMany(mappedBy="post")
	private Collection<Comment> comments;
	
	public Post(String title, String body, Category category) {
		this.title = title;
		this.body = body;
		this.category = category;
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
	
	
}
