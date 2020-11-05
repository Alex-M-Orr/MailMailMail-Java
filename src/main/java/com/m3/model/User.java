package com.m3.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column(nullable = false)
	private LocalDateTime dateJoined;
	@Column
	private String photo;

	@OneToMany(mappedBy = "id")
	private Set<Post> posts;

	@OneToMany(mappedBy = "id")
	private Set<Comment> comments;

	@OneToMany(mappedBy = "id")
	private Set<Like> likes;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String email, String password, String firstName, String lastName, LocalDateTime dateJoined,
			String photo, Set<Post> posts, Set<Comment> comments, Set<Like> likes) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateJoined = dateJoined;
		this.photo = photo;
		this.posts = posts;
		this.comments = comments;
		this.likes = likes;
	}

	public User(String email, String password, String firstName, String lastName, LocalDateTime dateJoined,
			String photo, Set<Post> posts, Set<Comment> comments, Set<Like> likes) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateJoined = dateJoined;
		this.photo = photo;
		this.posts = posts;
		this.comments = comments;
		this.likes = likes;
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

	public Set<Post> getPosts() {
		return posts;
	}

	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<Like> getLikes() {
		return likes;
	}

	public void setLikes(Set<Like> likes) {
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", dateJoined=" + dateJoined + ", photo=" + photo + ", posts=" + posts
				+ ", comments=" + comments + ", likes=" + likes + "]";
	}

//	private int id;
//	private String username;
//	private String password;
//	private String firstName;
//	private String lastName;
//	private LocalDateTime dateJoined;
//	private String photo;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Friendship", joinColumns = { @JoinColumn(name = "senderId") }, inverseJoinColumns = {
			@JoinColumn(name = "receiverID") })
	private Set<User> friends = new HashSet<User>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Friendship", joinColumns = { @JoinColumn(name = "receiverId") }, inverseJoinColumns = {
			@JoinColumn(name = "senderId") })
	private Set<User> friendsOf = new HashSet<User>();

}















