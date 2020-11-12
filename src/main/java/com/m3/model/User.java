package com.m3.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * <h1>User</h1>
 * <p>
 * The User class is a model representation of all of the information about a user
 * in the database.
 * </p>
 * <p>
 * This component uses annotations to indicate that it is an entity, and to
 * indicate the meaning of its fields.
 * </p>
 * 
 * @authors Alex Orr, Enoch Cho, Jordan Hunnicutt, Robert Porto, Tyrone
 *          Veneracion
 *
 */
@Entity
public class User {

	/**
	 * <p>
	 * Id is a serially implemented value in the database. It is used to refer
	 * to a specific User entry.
	 * </p>
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/**
	 * <p>Email is a string holding a user's email address.</p>
	 * <p>It is a column, it can't be null, and it must be unique across users.</p>
	 */
	@Column(nullable = false, unique = true)
	private String email;
	
	/**
	 * <p>Password is a string holding a user's password.</p>
	 * <p>It is a column, and it can't be null.</p>
	 */
	@Column(nullable = false)
	private String password;
	
	/**
	 * <p>FirstName is a string holding a user's first name.</p>
	 * <p>It is a column, and it can't be null.</p>
	 */
	@Column(nullable = false)
	private String firstName;
	
	/**
	 * <p>LastName is a string holding a user's last name.</p>
	 * <p>It is a column, and it can't be null.</p>
	 */
	@Column(nullable = false)
	private String lastName;
	
	/**
	 * <p>Photo is a string holding the name of a user's profile picture.</p>
	 * <p>It is a column in the database.</p>
	 */
	@Column
	private String photo;

	/**
	 * <p>Posts holds a set of post objects that the user has made.</p>
	 * <p>One user can have many posts.</p>
	 */
	@OneToMany(mappedBy = "author")
	private Set<Post> posts;

	/**
	 * <p>Comments holds a set of comment objects that the user has made.</p>
	 * <p>One user can have many comments.</p>
	 */
	@OneToMany(mappedBy = "author")
	private Set<Comment> comments;

	/**
	 * <p>Likes holds a set of like objects that the user has made.</p>
	 * <p>One user can have many likes.</p>
	 */
	@OneToMany(mappedBy = "author")
	private Set<Like> likes;

	/**
	 * <p>The user can be instantiated with a no-argument constructor.</p>
	 */
	public User() {
		super();
		// TODO Auto-generated constructor stub
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
	 * @param Set<Post> posts
	 * @param Set<Comment> comments
	 * @param Set<Like> likes
	 */
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

	/**
	 * <p>This constructor contains all of the user's fields as inputs, excluding the id.</p>
	 * 
	 * @param String email
	 * @param String password
	 * @param String firstName
	 * @param String lastName
	 * @param String photo
	 * @param Set<Post> posts
	 * @param Set<Comment> comments
	 * @param Set<Like> likes
	 */
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

	/**
	 * <p>This constructor takes in a UserBuilt object.</p>
	 * <p>User objects are stored in the database, but UserBuilt objects
	 * are passed to the front end, so this constructor does a conversion.</p>
	 * 
	 * @param UserBuilt ub
	 */
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

	/**
	 * <p>The toString method is an override that returns the values of different
	 * fields in the user object.</p>
	 * 
	 * return String
	 */
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
