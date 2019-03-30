package com.hockeyforum.hockeyforum.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Post post;
	private String comment;
	public Comment(Post post, String comment) {
		this.post = post;
		this.comment = comment;
	}
	
	public Long getId() {
		return id;
	}
	public Post getPost() {
		return post;
	}
	public String getComment() {
		return comment;
	}
	
	
}
