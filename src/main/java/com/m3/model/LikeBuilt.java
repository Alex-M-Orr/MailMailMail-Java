package com.m3.model;

import java.time.LocalDateTime;

/**
 * 
 * <h1>LikeBuilt</h1>
 * <p>
 * The LikeBuilt class is a model representation of all of the information about
 * a like in the database, using id values to refer to other objects.
 * </p>
 * <p>
 * The purpose of this component is to return values to a front-end application
 * with returning recursive objects.
 * </p>
 * 
 * @authors Alex Orr, Enoch Cho, Jordan Hunnicutt, Robert Porto, Tyrone
 *          Veneracion
 *
 */
public class LikeBuilt {
	/**
	 * <p>
	 * Id is a serially implemented value in the database. It is used to refer to a
	 * specific Like entry.
	 * </p>
	 */

	private int id;
	/**
	 * <p>
	 * PostId is an integer that represents the primary key of the post that the
	 * like object is associated with.
	 * 
	 * </p>
	 */
	private int postId;
	/**
	 * <p>
	 * CommentId is an integer that represents the primary key of the comment that
	 * the like object is associated with.
	 * 
	 * </p>
	 */
	private int commentId;
	/**
	 * <p>
	 * AuthorId is an integer that represents the primary key of the user that
	 * created the like object.
	 * 
	 * </p>
	 */
	private int authorId;
	/**
	 * <p>
	 * DateCreated is a LocalDateTime object representing when the like was created.
	 * The dateCreated object is created as soon as the like is made.
	 * </p>
	 */
	private LocalDateTime dateCreated;

	/**
	 * <p>
	 * This is a constructor for the LikeBuilt model with the following fields.
	 * </p>
	 * 
	 * @param id
	 * @param post
	 * @param comment
	 * @param author
	 * @param dateCreated
	 */
	public LikeBuilt(int id, int post, int comment, int author, LocalDateTime dateCreated) {
		super();
		this.id = id;
		this.postId = post;
		this.commentId = comment;
		this.authorId = author;
		this.dateCreated = dateCreated;
	}

	/**
	 * <p>
	 * This is a constructor for the LikeBuilt model with the following fields.
	 * </p>
	 * 
	 * @param post
	 * @param comment
	 * @param author
	 * @param dateCreated
	 */

	public LikeBuilt(int post, int comment, int author, LocalDateTime dateCreated) {
		super();
		this.postId = post;
		this.commentId = comment;
		this.authorId = author;
		this.dateCreated = dateCreated;
	}

	/**
	 * <p>
	 * This constructor takes in a Like object.
	 * </p>
	 * <p>
	 * Like objects are stored in the database, but LikeBuilt objects are passed to
	 * the front end, so this constructor does a conversion.
	 * </p>
	 * 
	 * @param l
	 */
	public LikeBuilt(Like l) {
		super();
		this.id = l.getId();

		try {
			this.postId = l.getPost().getId();
		} catch (NullPointerException e) {
			this.postId = 0;
		}
		try {
			this.commentId = l.getComment().getId();
		} catch (NullPointerException e) {
			this.commentId = 0;
		}
		try {
			this.authorId = l.getAuthor().getId();
		} catch (NullPointerException e) {
			this.authorId = 0;
		}

		this.dateCreated = l.getDateCreated();
	}

	public LikeBuilt() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPost() {
		return postId;
	}

	public void setPost(int post) {
		this.postId = post;
	}

	public int getCommentId() {
		return commentId;
	}

	public void setComment(int comment) {
		this.commentId = comment;
	}

	public int getAuthorId() {
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

	/**
	 * <p>
	 * The toString method is an override that returns the values of different
	 * fields in the likeBuilt object.
	 * </p>
	 * 
	 * return String
	 */
	@Override
	public String toString() {
		return "Like [id=" + id + ", dateCreated=" + dateCreated + "]";
	}

}
