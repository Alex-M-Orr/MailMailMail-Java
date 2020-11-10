package com.m3.model;

import java.time.LocalDateTime;


public class PostBuilt {

	private int id;
	private String content;
	private String photo;
	private int authorId;
	private LocalDateTime dateCreated;

	public PostBuilt(String content, String photo, int authorId, LocalDateTime dateCreated) {
		super();
		this.content = content;
		this.photo = photo;
		this.authorId = authorId;
		this.dateCreated = dateCreated;
	}

	public PostBuilt(int id, String content, String photo, int authorId, LocalDateTime dateCreated) {
		super();
		this.id = id;
		this.content = content;
		this.photo = photo;
		this.authorId = authorId;
		this.dateCreated = dateCreated;
	}

	public PostBuilt(Post post) {
		super();
		this.id = post.getId();
		this.content = post.getContent();
		this.photo = post.getPhoto();
		this.authorId = post.getAuthor().getId();
		this.dateCreated = post.getDateCreated();
	}
	
	
	public PostBuilt() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getAuthorId() {
		return authorId;
	}

	public void setAuthor(int authorId) {
		this.authorId = authorId;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

//	Changed from author= author-object to authorId = author.getId()
	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + ", authorId=" + authorId + ", dateCreated="
				+ dateCreated + "]";
	}

}
