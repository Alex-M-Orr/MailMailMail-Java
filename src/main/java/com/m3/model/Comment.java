package com.m3.model;

import java.time.LocalDateTime;

public class Comment {
	private int id;
	private String content;;
	private int postId;
	private int author;
	private LocalDateTime dateCreated;
	public Comment(int id, String content, int postId, int author, LocalDateTime dateCreated) {
		super();
		this.id = id;
		this.content = content;
		this.postId = postId;
		this.author = author;
		this.dateCreated = dateCreated;
	}
	public Comment(String content, int postId, int author, LocalDateTime dateCreated) {
		super();
		this.content = content;
		this.postId = postId;
		this.author = author;
		this.dateCreated = dateCreated;
	}
	public Comment() {
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
	public void setPostId(int postId) {
		this.postId = postId;
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
	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", postId=" + postId + ", author=" + author
				+ ", dateCreated=" + dateCreated + "]";
	}
	
	
}
