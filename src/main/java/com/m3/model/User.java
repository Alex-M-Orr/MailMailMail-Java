package com.m3.model;

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
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String firstName;
	@Column(nullable = false)
	private String lastName;
	@Column
	private String photo;

	@OneToMany(mappedBy = "author")
	private Set<Post> posts;

	@OneToMany(mappedBy = "author")
	private Set<Comment> comments;

	@OneToMany(mappedBy = "author")
	private Set<Like> likes;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int id, String email, String password, String firstName, String lastName,
			String photo, Set<Post> posts, Set<Comment> comments, Set<Like> likes) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.photo = photo;
		this.posts = posts;
		this.comments = comments;
		this.likes = likes;
	}

	public User(String email, String password, String firstName, String lastName,
			String photo, Set<Post> posts, Set<Comment> comments, Set<Like> likes) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.photo = photo;
		this.posts = posts;
		this.comments = comments;
		this.likes = likes;
	}

	public User(UserBuilt ub) {
		super();
		this.id = ub.getId();
		try {
			this.email = ub.getEmail();
		}catch (Exception e) {
			this.email = "";
		}
		try {
			this.password = ub.getPassword();
		} catch (Exception e) {
			this.password = "";
		}
		try {
			this.firstName = ub.getFirstName();
		} catch (Exception e) {
			this.firstName = "";
		}
		try {
			this.lastName = ub.getLastName();
		} catch (Exception e) {
			this.lastName = "";
		}
		try {
			this.photo = ub.getPhoto();
		} catch (Exception e) {
			this.photo = "";
		}
		this.posts = null;
		this.comments = null;
		this.likes = null;
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
		try {
			this.email = email;
		} catch (Exception e) {

		}
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		try {
			this.password = password;
		} catch (Exception e) {

		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		try {
			this.firstName = firstName;
		} catch (Exception e) {

		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		try {
			this.lastName = lastName;
		} catch (Exception e) {

		}
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
				+ ", lastName=" + lastName  + ", photo=" + photo + "]";
	}

//	private int id;
//	private String username;
//	private String password;
//	private String firstName;
//	private String lastName;
//	private LocalDateTime dateJoined;
//	private String photo;

//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "Friendship", joinColumns = { @JoinColumn(name = "senderId") }, inverseJoinColumns = {
//			@JoinColumn(name = "receiverID") })
//	private Set<User> friends = new HashSet<User>();
//
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinTable(name = "Friendship", joinColumns = { @JoinColumn(name = "receiverId") }, inverseJoinColumns = {
//			@JoinColumn(name = "senderId") })
//	private Set<User> friendsOf = new HashSet<User>();

//	@Override
//	public boolean equals(Object o) {
//		if (this == o)
//			return true;
//		if (o == null || getClass() != o.getClass())
//			return false;
//		User u = (User) o;
//		return Objects.equals(u.getEmail(), email);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(email);
//	}
}
