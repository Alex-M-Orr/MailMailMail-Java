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
public class Like {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="postId", referencedColumnName="id")
	private Post post;
	
	@ManyToOne
	@JoinColumn(name="commentId", referencedColumnName = "id")
	private Comment comment;
	
	@ManyToOne
	@JoinColumn(name="authorId", referencedColumnName = "id")
	private User author;
	
	@Column
	private LocalDateTime dateCreated;

	public Like(int id, Post post, Comment comment, User author, LocalDateTime dateCreated) {
		super();
		this.id = id;
		this.post = post;
		this.comment = comment;
		this.author = author;
		this.dateCreated = dateCreated;
	}

	public Like(Post post, Comment comment, User author, LocalDateTime dateCreated) {
		super();
		this.post = post;
		this.comment = comment;
		this.author = author;
		this.dateCreated = dateCreated;
	}
	
	public Like() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		try {
			this.id = id;
		} catch (Exception e) {
			
		}
		
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		try {
			this.post = post;
		} catch (Exception e) {
			
		}
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		try {
			this.comment = comment;
		} catch (Exception e) {
			
		}
	}

	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		try {
			this.author = author;
		} catch (Exception e) {
			
		}
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {	
		try {
			this.dateCreated = dateCreated;
		} catch (Exception e) {
			
		}
	}

	@Override
	public String toString() {
		return "Like [id=" + id + ", dateCreated="
				+ dateCreated + "]";
	}

	
	
}
