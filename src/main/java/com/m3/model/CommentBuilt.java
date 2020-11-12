package com.m3.model;

import java.time.LocalDateTime;

/**
 * 
 * <h1>CommentBuilt</h1>
 * <p>
 * The CommentBuilt class is a model representation of all of the information
 * about a comment in the database, using id values to refer to other objects.
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
public class CommentBuilt {

	/**
	 * <p>
	 * Id is a serially implemented value in the database. It is used to refer to a
	 * specific Comment entry.
	 * </p>
	 */
	private int id;
	/**
	 * <p>
	 * Content is a string representing the content of the comment. This would be
	 * whatever the user wrote in the comment.
	 * </p>
	 */
	private String content;
	/**
	 * <p>
	 * PostId holds is an integer that represents the primary key of the post that
	 * is associated with the Comment object.
	 * </p>
	 */
	private int postId;
	/**
	 * <p>
	 * AuthorId holds is an integer that represents the primary key of the user that
	 * is associated with the Comment object.
	 * </p>
	 */
	private int authorId;
	/**
	 * <p>
	 * DateCreated is a LocalDateTime object representing the date that the comment
	 * was entered in the database.
	 * </p>
	 */
	private LocalDateTime dateCreated;

	/**
	 * <p>
	 * This constructor contains the following Comments's fields as inputs.
	 * </p>
	 * 
	 * @param id
	 * @param content
	 * @param post
	 * @param author
	 * @param dateCreated
	 */
	public CommentBuilt(int id, String content, int post, int author, LocalDateTime dateCreated) {
		super();
		this.id = id;
		this.content = content;
		this.postId = post;
		this.authorId = author;
		this.dateCreated = dateCreated;
	}

	/**
	 * 
	 * <p>
	 * This constructor contains the following Comments's fields as inputs.
	 * </p>
	 * 
	 * @param content
	 * @param post
	 * @param author
	 * @param dateCreated
	 */
	public CommentBuilt(String content, int post, int author, LocalDateTime dateCreated) {
		super();
		this.content = content;
		this.postId = post;
		this.authorId = author;
		this.dateCreated = dateCreated;
	}

	/**
	 * 
	 * <p>
	 * This constructor takes in a Comment object.
	 * </p>
	 * <p>
	 * Comment objects are stored in the database, but CommentBuilt objects are
	 * passed to the front end, so this constructor does a conversion.
	 * </p>
	 * 
	 *
	 * 
	 * @param c
	 */

	public CommentBuilt(Comment c) {
		super();
		this.id = c.getId();
		this.content = c.getContent();
		this.postId = c.getPost().getId();
		this.authorId = c.getAuthor().getId();
		this.dateCreated = c.getDateCreated();
	}

	public CommentBuilt() {
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

	public void setPostId(int post) {
		this.postId = post;
	}

	public int getAuthor() {
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
