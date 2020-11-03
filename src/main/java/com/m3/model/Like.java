package com.m3.model;

import java.time.LocalDateTime;

public class Like {
	private int id;
	private int postId;
	private int commentId;
	private int author;
	private LocalDateTime dateCreated;

	public Like(int id, int postId, int commentId, int author, LocalDateTime dateCreated) {
		super();
		this.id = id;
		this.postId = postId;
		this.commentId = commentId;
		this.author = author;
		this.dateCreated = dateCreated;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

}
