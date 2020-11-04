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
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String content;
	
	@ManyToOne
	@JoinColumn(name="postId", referencedColumnName="id")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name="authorId", referencedColumnName = "id")
	private User author;
	
	@Column
	private LocalDateTime dateCreated;
	
	public Comment(int id, String content, Post post, User author, LocalDateTime dateCreated) {
		super();
		this.id = id;
		this.content = content;
		this.post = post;
		this.author = author;
		this.dateCreated = dateCreated;
	}
	public Comment(String content, Post post, User author, LocalDateTime dateCreated) {
		super();
		this.content = content;
		this.post = post;
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
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
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
	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", post=" + post + ", author=" + author
				+ ", dateCreated=" + dateCreated + "]";
	}
	
	
}
