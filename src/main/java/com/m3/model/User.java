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

	@OneToMany(mappedBy = "post")
	private Set<Post> posts;

	@OneToMany(mappedBy = "comment")
	private Set<Comment> comments;

	@OneToMany(mappedBy = "like")
	private Set<Like> likes;

	@ManyToMany(mappedBy = "friends", cascade = CascadeType.ALL)
	@JoinTable(name = "Friendship", joinColumns = { @JoinColumn(name = "senderId") }, inverseJoinColumns = {
			@JoinColumn(name = "receiverID") })
	private Set<User> friends = new HashSet<User>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Friendship", joinColumns = { @JoinColumn(name = "receiverId") }, inverseJoinColumns = {
			@JoinColumn(name = "senderId") })
	private Set<User> friendsOf = new HashSet<User>();

}
