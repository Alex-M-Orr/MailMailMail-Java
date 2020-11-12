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

/**
 * 
 * <h1>Like</h1>
 * <p>
 * The Like class is a model representation of all of the information about a
 * user in the database.
 * </p>
 * <p>
 * This component uses annotations to indicate that it is an entity and to
 * specify the name of the table that it references in the database.
 * </p>
 * 
 * @authors Alex Orr, Enoch Cho, Jordan Hunnicutt, Robert Porto, Tyrone
 *          Veneracion
 *
 */
@Entity
@Table(name = "Likes")
public class Like {
	/**
	 * <p>
	 * The PostDao retrieves information about a Post from the database.
	 * </p>
	 * <p>
	 * We include it here for conversion between a Like and a LikeBuilt.
	 * </p>
	 */
	@Autowired
	private static PostDao pd;

	/**
	 * <p>
	 * The UserDao retrieves information about a User from the database.
	 * </p>
	 * <p>
	 * We include it here for conversion between a Like and a LikeBuilt.
	 * </p>
	 */
	@Autowired
	private static UserDao ud;
	/**
	 * <p>
	 * The CommentDao retrieves information about a Comment from the database.
	 * </p>
	 * <p>
	 * We include it here for conversion between a Like and a LikeBuilt.
	 * </p>
	 */
	@Autowired
	private static CommentDao cd;
	/**
	 * <p>
	 * Id is a serially implemented value in the database. It is used to refer to a
	 * specific Like entry.
	 * </p>
	 */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * <p>
	 * Like objects can be associated with a Post object. Many Likes can be
	 * associated with one Post.
	 * </p>
	 * <p>
	 * The Like object is associated with an entry in the Post table.
	 * </p>
	 */

	@ManyToOne
	@JoinColumn(name = "postId", referencedColumnName = "id")
	private Post post;
	/**
	 * <p>
	 * Like objects can be associated with a Comment object. Many Likes can be
	 * associated with one Comment.
	 * </p>
	 * <p>
	 * The Like object is associated with an entry in the Comment table.
	 * </p>
	 */

	@ManyToOne
	@JoinColumn(name = "commentId", referencedColumnName = "id")
	private Comment comment;

	/**
	 * <p>
	 * Like objects are associated with a User object. Many Likes can be created by
	 * one User.
	 * 
	 * </p>
	 * <p>
	 * The Like object is associated with an entry in the User table.
	 * </p>
	 */
	@ManyToOne
	@JoinColumn(name = "authorId", referencedColumnName = "id")
	private User author;

	/**
	 * <p>
	 * DateCreated is a LocalDateTime object representing the date when the Like
	 * entered the database.
	 * </p>
	 */
	@Column
	private LocalDateTime dateCreated;

	/**
	 * <p>
	 * This constructor contains the following fields as inputs.
	 * </p>
	 * 
	 * @param id
	 * @param post
	 * @param comment
	 * @param author
	 * @param dateCreated
	 */

	public Like(int id, Post post, Comment comment, User author, LocalDateTime dateCreated) {
		super();
		this.id = id;
		this.post = post;
		this.comment = comment;
		this.author = author;
		this.dateCreated = dateCreated;
	}

	/**
	 * <p>
	 * This constructor contains the following fields as inputs.
	 * </p>
	 * 
	 * @param post
	 * @param comment
	 * @param author
	 * @param dateCreated
	 */

	public Like(Post post, Comment comment, User author, LocalDateTime dateCreated) {
		super();
		this.post = post;
		this.comment = comment;
		this.author = author;
		this.dateCreated = dateCreated;
	}

	/**
	 * <p>
	 * This constructor takes in a LikeBuilt object.
	 * </p>
	 * <p>
	 * Like objects are stored in the database, but LikeBuilt objects are passed to
	 * the front end, so this constructor does a conversion.
	 * </p>
	 * 
	 * @param lb
	 */

	public Like(LikeBuilt lb) {
		super();
		this.id = lb.getId();
		try {
			this.post = pd.findById(lb.getPost());
		} catch (Exception e) {
			this.post = null;
		}
		try {
			this.comment = cd.findById(lb.getCommentId());
		} catch (Exception e) {
			this.comment = null;
		}
		try {
			this.author = ud.findById(lb.getAuthorId());
		} catch (Exception e) {
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

	/**
	 * <p>
	 * The toString method is an override that returns the values of different
	 * fields in the like object.
	 * </p>
	 * 
	 * return String
	 */
	@Override
	public String toString() {
		return "Like [id=" + id + ", dateCreated=" + dateCreated + "]";
	}

}
