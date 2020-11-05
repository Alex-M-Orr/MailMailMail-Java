package com.m3.model;

import java.time.LocalDateTime;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

public class Friendship {
	@EmbeddedId
	FriendshipKey id;

	@ManyToOne
	@MapsId("senderId")
	@JoinColumn(name = "sender_id")
	User sender;

	@ManyToOne
	@MapsId("senderId")
	@JoinColumn(name = "sender_id")
	User receiver;

	private boolean accepted;
	private LocalDateTime date;

	public FriendshipKey getId() {
		return id;
	}

	public void setId(FriendshipKey id) {
		this.id = id;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getreceiver() {
		return receiver;
	}

	public void setreceiver(User receiver) {
		this.receiver = receiver;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}