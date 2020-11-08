package com.m3.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class LikeBuilt {
	
	private int id;
	private int postId;
	private int commentId;
	private int authorId;
	private LocalDateTime dateCreated;

	public LikeBuilt(int id, int post, int comment, int author, LocalDateTime dateCreated) {
		super();
		this.id = id;
		this.postId = post;
		this.commentId = comment;
		this.authorId = author;
		this.dateCreated = dateCreated;
	}

	public LikeBuilt(int post, int comment, int author, LocalDateTime dateCreated) {
		super();
		this.postId = post;
		this.commentId = comment;
		this.authorId = author;
		this.dateCreated = dateCreated;
	}
	
	public LikeBuilt(Like l) {
		super();
		this.id = l.getId();
		
		try {
			this.postId = l.getPost().getId();
		} catch (NullPointerException e) {
			this.postId = 0;
		}
		try {
			this.commentId = l.getComment().getId();
		} catch (NullPointerException e) {
			this.commentId = 0;
		}
		try {
			this.authorId = l.getAuthor().getId();
		} catch (NullPointerException e) {
			this.authorId = 0;
		}
		
		this.dateCreated = l.getDateCreated();
	}
	
	public LikeBuilt() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPost() {
		return postId;
	}

	public void setPost(int post) {
		this.postId = post;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setComment(int comment) {
		this.commentId = comment;
	}

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthor(int author) {
		this.authorId = author;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Like [id=" + id + ", dateCreated="
				+ dateCreated + "]";
	}

	
	
}
