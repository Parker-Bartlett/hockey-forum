package com.hockeyforum.hockeyforum.models;

import javax.persistence.Embeddable;


@Embeddable
public class Comment {

	private String commentContent;
	
	public Comment() {}
	
	public Comment(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentContent() {
		return commentContent;
	}
	
	
}
