package com.hockeyforum.hockeyforum.models;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Category {
	
	@Id
	@GeneratedValue
	private Long id;
	private String title;
	@OneToMany (mappedBy="category")
	private Collection<Post> posts;
	
	public Category(String title) {
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Collection<Post> getPosts() {
		return posts;
	}
	
	
}
