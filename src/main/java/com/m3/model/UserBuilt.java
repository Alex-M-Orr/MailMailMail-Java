package com.m3.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
/**
 * 
 * <h1>UserBuilt</h1>
 * <p>
 * The UserBuilt class is a model representation of all of the information about a user
 * in the database, using id values to refer to other objects.
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
public class UserBuilt {

	/**
	 * <p>
	 * Id is a serially implemented value in the database. It is used to refer
	 * to a specific User entry.
	 * </p>
	 */
	private int id;

	/**
	 * <p>Email is a string holding a user's email address.</p>
	 */
	private String email;
	
	/**
	 * <p>Password is a string holding a user's password.</p>
	 */
	private String password;
	
	/**
	 * <p>FirstName is a string holding a user's first name.</p>
	 */
	private String firstName;
	
	/**
	 * <p>LastName is a string holding a user's last name.</p>
	 */
	private String lastName;
	
	/**
	 * <p>DateJoined is a LocalDateTime holding the date the user entered the database.</p>
	 */
	private LocalDateTime dateJoined;
	
	/**
	 * <p>Photo is a string holding the name of a user's profile picture.</p>
	 */
	private String photo;

	/**
	 * <p>PostIds holds a set of post ids that the user has made.</p>
	 */
	private Set<Integer> postIds;

	/**
	 * <p>CommentIds holds a set of comment ids that the user has made.</p>
	 */
	private Set<Integer> commentIds;

	/**
	 * <p>LikeIds holds a set of like ids that the user has made.</p>
	 */
	private Set<Integer> likeIds;

	/**
	 * <p>This constructor takes in a User object.</p>
	 * <p>User objects are stored in the database, but UserBuilt objects
	 * are passed to the front end, so this constructor does a conversion.</p>
	 * 
	 * @param User user
	 */
	public UserBuilt(User user) {
		super();
		this.id = user.getId();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.photo = user.getPhoto();

		if (user.getPosts() == null) {

			this.postIds = null;
		} else {
			this.postIds = new HashSet<>();
			for (Post p : user.getPosts()) {
				this.postIds.add(p.getId());
			}
		}

		if (user.getComments() == null) {
			this.commentIds = null;
		} else {
			this.commentIds = new HashSet<>();
			for (Comment c : user.getComments()) {
				this.commentIds.add(c.getId());
			}
		}

		if (user.getLikes() == null) {
			this.likeIds = null;
		} else {
			this.likeIds = new HashSet<>();
			for (Like l : user.getLikes()) {
				this.likeIds.add(l.getId());
			}
		}

	}

	/**
	 * <p>This constructor contains all of the user's fields as inputs.</p>
	 * 
	 * @param int id
	 * @param String email
	 * @param String password
	 * @param String firstName
	 * @param String lastName
	 * @param String photo
	 * @param Set<Integer> postIds
	 * @param Set<Integer> commentIds
	 * @param Set<Integer> likeIds
	 */
	public UserBuilt(int id, String email, String password, String firstName, String lastName, String photo,
			Set<Integer> postIds, Set<Integer> commentIds, Set<Integer> likeIds) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.photo = photo;
		this.postIds = postIds;
		this.commentIds = commentIds;
		this.likeIds = likeIds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDateTime getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(LocalDateTime dateJoined) {
		this.dateJoined = dateJoined;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Set<Integer> getPostIds() {
		return postIds;
	}

	public void setPostIds(Set<Integer> postIds) {
		this.postIds = postIds;
	}

	public Set<Integer> getCommentIds() {
		return commentIds;
	}

	public void setCommentIds(Set<Integer> commentIds) {
		this.commentIds = commentIds;
	}

	public Set<Integer> getLikeIds() {
		return likeIds;
	}

	public void setLikeIds(Set<Integer> likeIds) {
		this.likeIds = likeIds;
	}

}