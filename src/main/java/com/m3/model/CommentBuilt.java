package com.m3.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class CommentBuilt {
	

	private int id;
	private String content;
	private int postId;
	private int authorId;
	private LocalDateTime dateCreated;
	
	public CommentBuilt(int id, String content, int post, int author, LocalDateTime dateCreated) {
		super();
		this.id = id;
		this.content = content;
		this.postId = post;
		this.authorId = author;
		this.dateCreated = dateCreated;
	}
	public CommentBuilt(String content, int post, int author, LocalDateTime dateCreated) {
		super();
		this.content = content;
		this.postId = post;
		this.authorId = author;
		this.dateCreated = dateCreated;
	}
	public CommentBuilt(Comment c) {
		super();
		this.id = c.getId();
		this.content = c.getContent();
		this.postId = c.getPost().getId();
		this.authorId = c.getAuthor().getId();
		this.dateCreated = c.getDateCreated();
	}
	public CommentBuilt() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int post) {
		this.postId = post;
	}
	public int getAuthor() {
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
		return "Comment [id=" + id + ", content=" + content + ", dateCreated=" + dateCreated + "]";
	}
	
	
}
