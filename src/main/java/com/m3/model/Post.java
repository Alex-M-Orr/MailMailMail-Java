package com.m3.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String content;
	@Column
	private String photo;
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User author;
	@Column(nullable = false)
	private LocalDateTime dateCreated;

	public Post(String content, String photo, User author, LocalDateTime dateCreated) {
		super();
		this.content = content;
		this.photo = photo;
		this.author = author;
		this.dateCreated = dateCreated;
	}
	public Post(int id, String content, String photo, User author, LocalDateTime dateCreated) {
		super();
		this.id = id;
		this.content = content;
		this.photo = photo;
		this.author = author;
		this.dateCreated = dateCreated;
	}
	public Post() {
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
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
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
	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + ", dateCreated=" + dateCreated + "]";
	}
	
	
	
}
