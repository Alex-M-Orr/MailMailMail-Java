package com.m3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FriendshipKey implements Serializable {

	@Column(name = "sender_id")
	int senderId;

	@Column(name = "receiver_id")
	int receiverId;

	@Column(name = "accepted")
	boolean accepted;

	public FriendshipKey(int senderId, int receiverId, boolean accepted) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.accepted = accepted;
	}

	public FriendshipKey(int senderId, int receiverId) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.accepted = false;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getreceiverId() {
		return receiverId;
	}

	public void setreceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	public boolean isAccepted() {
		return accepted;
	}

	public void setAccepted(boolean accepted) {
		this.accepted = accepted;
	}

}
