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

import com.m3.dao.UserDao;

/**
 * 
 * <h1>Post</h1>
 * <p>
 * The Post class is a model representation of all of the information about a
 * post in the database.
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
public class Post {

	/**
	 * <p>
	 * The UserDao retrieves information about a User from the database.
	 * </p>
	 * <p>
	 * We include it here for conversion between a Post and a PostBuilt.
	 * </p>
	 */
	@Autowired
	private static UserDao ud;

	/**
	 * <p>
	 * Id is a serially implemented value in the database. It is used to refer to a
	 * specific Post entry.
	 * </p>
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * <p>
	 * Content is a string holding the text inside of a post.
	 * </p>
	 * <p>
	 * It is a column in the database.
	 * </p>
	 */
	@Column
	private String content;

	/**
	 * <p>
	 * Photo is a string holding the name of a post's picture.
	 * </p>
	 * <p>
	 * It is a column in the database.
	 * </p>
	 */
	@Column
	private String photo;

	/**
	 * <p>
	 * Author holds a reference to the user who made the post
	 * </p>
	 * <p>
	 * There can be many posts held by one user.
	 * </p>
	 * 
	 */
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User author;

	/**
	 * <p>
	 * DateCreated is a LocalDateTime object representing the date that the post was
	 * entered in the database.
	 * </p>
	 */
	@Column(nullable = false)
	private LocalDateTime dateCreated;

	/**
	 * <p>
	 * This constructor contains all of the post's fields as inputs, excluding the
	 * id.
	 * </p>
	 * 
	 * @param content
	 * @param photo
	 * @param author
	 * @param dateCreated
	 */
	public Post(String content, String photo, User author, LocalDateTime dateCreated) {
		super();
		this.content = content;
		this.photo = photo;
		this.author = author;
		this.dateCreated = dateCreated;
	}

	/**
	 * <p>
	 * This constructor contains all of the post's fields as inputs.
	 * </p>
	 * 
	 * @param id
	 * @param content
	 * @param photo
	 * @param author
	 * @param dateCreated
	 */
	public Post(int id, String content, String photo, User author, LocalDateTime dateCreated) {
		super();
		this.id = id;
		this.content = content;
		this.photo = photo;
		this.author = author;
		this.dateCreated = dateCreated;
	}

	/**
	 * <p>
	 * This constructor contains all of the post's fields as inputs, excluding the
	 * date created.
	 * </p>
	 * 
	 * @param id
	 * @param content
	 * @param photo
	 * @param author
	 */
	public Post(int id, String content, String photo, User author) {
		super();
		this.id = id;
		this.content = content;
		this.photo = photo;
		this.author = author;
		this.dateCreated = LocalDateTime.now();
	}

	/**
	 * <p>
	 * This constructor takes in a PostBuilt object.
	 * </p>
	 * <p>
	 * Post objects are stored in the database, but PostBuilt objects are passed to
	 * the front end, so this constructor does a conversion.
	 * </p>
	 * 
	 * @param PostBuilt pb
	 */
	public Post(PostBuilt pb) {
		super();
		this.id = pb.getId();
		try {
			this.content = pb.getContent();
		} catch (Exception e) {
			this.content = "";
		}
		try {
			this.photo = pb.getPhoto();
		} catch (Exception e) {
			this.photo = "";
		}
		try {
			this.author = ud.findById(pb.getAuthorId());
		} catch (Exception e) {
			this.author = null;
		}
		try {
			this.dateCreated = pb.getDateCreated();
		} catch (Exception e) {
			this.dateCreated = LocalDateTime.now();
		}
	}

	/**
	 * <p>
	 * The post can be instantiated with a no-argument constructor.
	 * </p>
	 */
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
		try {
			this.content = content;
		} catch (Exception e) {

		}
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
		try {
			this.photo = photo;
		} catch (Exception e) {

		}

	}

	/**
	 * <p>
	 * The toString method is an override that returns the values of different
	 * fields in the post object.
	 * </p>
	 * 
	 * return String
	 */
	@Override
	public String toString() {
		return "Post [id=" + id + ", content=" + content + ", authorId=" + author.getId() + ", dateCreated="
				+ dateCreated + "]";
	}

}
