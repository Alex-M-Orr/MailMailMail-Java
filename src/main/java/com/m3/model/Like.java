package com.m3.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.m3.dao.CommentDao;
import com.m3.dao.PostDao;
import com.m3.dao.UserDao;

@Entity
@Table(name="Likes")
public class Like {
	
	@Autowired
	private static PostDao pd;
	@Autowired
	private static UserDao ud;
	@Autowired
	private static CommentDao cd;
	
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
	
	public Like(LikeBuilt lb) {
		super();
		this.id = lb.getId();
		try {
			this.post = pd.findById(lb.getPost());
		} catch(Exception e){
			this.post = null;
		}
		try {
			this.comment = cd.findById(lb.getCommentId());
		} catch(Exception e){
			this.comment = null;
		}
		try {
			this.author = ud.findById(lb.getAuthorId());
		} catch(Exception e){
			this.author = null;
		}
		try {
			this.dateCreated = lb.getDateCreated();
		} catch (Exception e) {
			this.dateCreated = LocalDateTime.now();
		}		
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
