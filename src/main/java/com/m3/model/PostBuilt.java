package com.m3.model;

import java.time.LocalDateTime;

/**
 * 
 * <h1>PostBuilt</h1>
 * <p>
 * The PostBuilt class is a model representation of all of the information about
 * a post in the database, using id values to refer to other objects.
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

public class PostBuilt {

	/**
	 * <p>
	 * Id is a serially implemented value in the database. It is used to refer to a
	 * specific Post entry.
	 * </p>
	 */

	private int id;
	/**
	 * <p>
	 * Content is a string representing the content of the post. This would be
	 * whatever the user wrote in the post .
	 * </p>
	 */
	private String content;
	/**
	 * <p>
	 * Photo is a string holding the name of a post's picture.
	 * </p>
	 * <p>
	 * It is a column in the database.
	 * </p>
	 */
	private String photo;
	/**
	 * <p>
	 * AuthorId is an integer that represents the primary key of the user that wrote
	 * the post.
	 * </p>
	 */
	private int authorId;
	/**
	 * <p>
	 * DateCreated is a LocalDateTime object representing when the post was created.
	 * The dateCreated object is created as soon as the post is made.
	 * </p>
	 */
	private LocalDateTime dateCreated;

	/**
	 * <p>
	 * This is a constructor for the PostBuilt model with the following fields.
	 * </p>
	 * 
	 * @param content
	 * @param photo
	 * @param authorId
	 * @param dateCreated
	 */
	public PostBuilt(String content, String photo, int authorId, LocalDateTime dateCreated) {
		super();
		this.content = content;
		this.photo = photo;
		this.authorId = authorId;
		this.dateCreated = dateCreated;
	}

	/**
	 * <p>
	 * This is a constructor for the PostBuilt model with the following fields.
	 * </p>
	 * 
	 * @param id
	 * @param content
	 * @param photo
	 * @param authorId
	 * @param dateCreated
	 */

	public PostBuilt(int id, String content, String photo, int authorId, LocalDateTime dateCreated) {
		super();
		this.id = id;
		this.content = content;
		this.photo = photo;
		this.authorId = authorId;
		this.dateCreated = dateCreated;
	}

	/**
	 * 
	 * <p>
	 * This constructor takes in a Post object.
	 * </p>
	 * <p>
	 * Post objects are stored in the database, but PostBuilt objects are passed to
	 * the front end, so this constructor does a conversion.
	 * </p>
	 * 
	 * @param post
	 */

	public PostBuilt(Post post) {
		super();
		this.id = post.getId();
		try {
			this.content = post.getContent();
		} catch (Exception e) {
			this.content = "";
		}
		try {
			this.photo = post.getPhoto();
		} catch (Exception e) {
			this.photo = "";
		}
		try {
			this.authorId = post.getAuthor().getId();
		} catch (Exception e) {
			this.authorId = 1;
		}
		try {
			this.dateCreated = post.getDateCreated();
		} catch (Exception e) {
			this.dateCreated = LocalDateTime.now();
		}
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

	/**
	 * <p>
	 * The toString method is an override that returns the values of different
	 * fields in the postBuilt object.
	 * </p>
	 * 
	 * return String
	 */
	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + ", authorId=" + authorId + ", dateCreated=" + dateCreated
				+ "]";
	}

}
