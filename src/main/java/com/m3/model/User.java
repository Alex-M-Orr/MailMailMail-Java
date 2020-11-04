package com.m3.model;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true)
	private String username;
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

	@OneToMany(mappedBy = "post")
	private Set<Post> posts;

	@OneToMany(mappedBy = "comment")
	private Set<Comment> comments;

	@OneToMany(mappedBy = "like")
	private Set<Like> likes;

//	private int id;
//	private String username;
//	private String password;
//	private String firstName;
//	private String lastName;
//	private LocalDateTime dateJoined;
//	private String photo;
//
	public User(int id, String username, String password, String firstName, String lastName, LocalDateTime dateJoined,
			String photo) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateJoined = dateJoined;
		this.photo = photo;
	}

	public User(String username, String password, String firstName, String lastName, LocalDateTime dateJoined,
			String photo) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateJoined = dateJoined;
		this.photo = photo;
	}

	public User() {
		super();

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

}
