package com.m3.model;

import java.time.LocalDateTime;

public class Post {
	private int id;
	private String content;
	private int author;
	private LocalDateTime dateCreated;
	public Post(int id, String content, int author, LocalDateTime dateCreated) {
		super();
		this.id = id;
		this.content = content;
		this.author = author;
		this.dateCreated = dateCreated;
	}
	public Post(String content, int author, LocalDateTime dateCreated) {
		super();
		this.content = content;
		this.author = author;
		this.dateCreated = dateCreated;
	}
	public Post() {
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
		return "Post [id=" + id + ", content=" + content + ", author=" + author + ", dateCreated=" + dateCreated + "]";
	}
	
	
}
