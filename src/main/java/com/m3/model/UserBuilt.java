package com.m3.model;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class UserBuilt {

	private int id;

	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private LocalDateTime dateJoined;
	private String photo;

	private Set<Integer> postIds;

	private Set<Integer> commentIds;

	private Set<Integer> likeIds;

	public UserBuilt(User user) {
		super();
		this.id = user.getId();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.dateJoined = user.getDateJoined();
		this.photo = user.getPhoto();

		if (user.getPosts().size() == 0) {

			this.postIds = null;
		} else {
			this.postIds = new HashSet<>();
			for (Post p : user.getPosts()) {
				this.postIds.add(p.getId());
			}
		}

		if (user.getComments().size() == 0) {
			this.commentIds = null;
		} else {
			this.commentIds = new HashSet<>();
			for (Comment c : user.getComments()) {
				this.commentIds.add(c.getId());
			}
		}

		if (user.getLikes().size() == 0) {
			this.likeIds = null;
		} else {
			this.likeIds = new HashSet<>();
			for (Like l : user.getLikes()) {
				this.likeIds.add(l.getId());
			}
		}

	}

	public UserBuilt(int id, String email, String password, String firstName, String lastName, LocalDateTime dateJoined,
			String photo, Set<Integer> postIds, Set<Integer> commentIds, Set<Integer> likeIds) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dateJoined = dateJoined;
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