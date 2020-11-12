package com.m3.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.beans.factory.annotation.Autowired;

import com.m3.dao.PostDao;
import com.m3.dao.UserDao;

/**
 * 
 * <h1>Comment</h1>
 * <p>
 * The Comment class is a model representation of all of the information about a
 * comment in the database.
 * </p>
 * <p>
 * This component uses annotations to indicate that it is an entity.
 * </p>
 * 
 * @authors Alex Orr, Enoch Cho, Jordan Hunnicutt, Robert Porto, Tyrone
 *          Veneracion
 *
 */
@Entity
public class Comment {
	/**
	 * <p>
	 * The PostDao retrieves information about a Post from the database.
	 * </p>
	 * <p>
	 * We include it here for conversion between a Comment and a CommentBuilt.
	 * </p>
	 */
	@Autowired
	private static PostDao pd;
	/**
	 * <p>
	 * The UserDao retrieves information about a Post from the database.
	 * </p>
	 * <p>
	 * We include it here for conversion between a Comment and a CommentBuilt.
	 * </p>
	 */
	@Autowired
	private static UserDao ud;

	/**
	 * <p>
	 * Id is a serially implemented value in the database. It is used to refer to a
	 * specific Comment entry.
	 * </p>
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * <p>
	 * Content is a string representing the content of the comment. This would be
	 * whatever the user wrote in the comment.
	 * </p>
	 */
	@Column
	private String content;

	/**
	 * <p>
	 * Comment objects are associated with a Post object. Many comments can be
	 * associated with one Post.
	 * </p>
	 * <p>
	 * The Comment object is associated with an entry in the Post table.
	 * </p>
	 */

	@ManyToOne
	@JoinColumn(name = "postId", referencedColumnName = "id")
	private Post post;

	/**
	 * <p>
	 * Comment objects are associated with a User object. Many comments can be
	 * associated with one User.
	 * </p>
	 * <p>
	 * The Comment object is associated with an entry in the User table.
	 * </p>
	 */

	@ManyToOne
	@JoinColumn(name = "authorId", referencedColumnName = "id")
	private User author;
	/**
	 * <p>
	 * DateCreated is a LocalDateTime object holding the date that the like entered
	 * the database.
	 * </p>
	 */
	@Column
	private LocalDateTime dateCreated;

	/**
	 * <p>
	 * This constructor contains all of the Comment's fields as inputs.
	 * </p>
	 * 
	 * @param id
	 * @param content
	 * @param post
	 * @param author
	 * @param dateCreated
	 */
	public Comment(int id, String content, Post post, User author, LocalDateTime dateCreated) {
		super();
		this.id = id;
		this.content = content;
		this.post = post;
		this.author = author;
		this.dateCreated = dateCreated;
	}

	/**
	 * <p>
	 * This constructor contains all of the Comment's fields as inputs.
	 * </p>
	 * 
	 * @param content
	 * @param post
	 * @param author
	 * @param dateCreated
	 */
	public Comment(String content, Post post, User author, LocalDateTime dateCreated) {
		super();
		this.content = content;
		this.post = post;
		this.author = author;
		this.dateCreated = dateCreated;
	}

	/**
	 * <p>
	 * This constructor contains all of the Comment's fields as inputs.
	 * </p>
	 * 
	 * 
	 * @param content
	 * @param post
	 * @param author
	 */
	public Comment(String content, Post post, User author) {
		super();
		this.content = content;
		this.post = post;
		this.author = author;
		this.dateCreated = LocalDateTime.now();
	}

	/**
	 * <p>
	 * This constructor takes in a CommentBuilt object.
	 * </p>
	 * <p>
	 * Comment objects are stored in the database, but CommentBuilt objects are
	 * passed to the front end, so this constructor does a conversion.
	 * </p>
	 * 
	 * @param cb
	 */

	public Comment(CommentBuilt cb) {
		super();
		this.id = cb.getId();
		try {
			this.content = cb.getContent();
		} catch (Exception e) {

		}
		try {
			this.post = pd.findById(cb.getPostId());
		} catch (Exception e) {
			this.post = null;
		}
		try {
			this.author = ud.findById(cb.getAuthor());
		} catch (Exception e) {
			this.author = null;
		}
		try {
			this.dateCreated = cb.getDateCreated();
		} catch (Exception e) {
			this.dateCreated = LocalDateTime.now();
		}
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

	/**
	 * <p>
	 * The toString method is an override that returns the values of different
	 * fields in the comment object.
	 * </p>
	 * 
	 * return String
	 */
	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", dateCreated=" + dateCreated + "]";
	}

}
