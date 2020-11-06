package com.m3.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FriendshipKey implements Serializable {

	@Column(name = "senderId")
	int senderId;

	@Column(name = "receiverId")
	int receiverId;

	public FriendshipKey(int senderId, int receiverId) {
		super();
		this.senderId = senderId;
		this.receiverId = receiverId;
	}

	public int getSenderId() {
		return senderId;
	}

	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}

	public int getReceiverId() {
		return receiverId;
	}

	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}

	@Override
	public String toString() {
		return "FriendshipKey [senderId=" + senderId + ", receiverId=" + receiverId + "]";
	}

	
	
//
//	@Column(name = "accepted")
//	boolean accepted;
//
//	public FriendshipKey(int senderId, int receiverId, boolean accepted, LocalDateTime date) {
//		super();
//		this.senderId = senderId;
//		this.receiverId = receiverId;
//		this.accepted = accepted;
//		this.date = date;
//	}
//
//	public int getReceiverId() {
//		return receiverId;
//	}
//
//	public void setReceiverId(int receiverId) {
//		this.receiverId = receiverId;
//	}
//
//	public LocalDateTime getDate() {
//		return date;
//	}
//
//	public void setDate(LocalDateTime date) {
//		this.date = date;
//	}
//
//	@Column(name = "date")
//	LocalDateTime date;
//
//	public FriendshipKey(int senderId, int receiverId, boolean accepted) {
//		super();
//		this.senderId = senderId;
//		this.receiverId = receiverId;
//		this.accepted = accepted;
//	}
//
//	public FriendshipKey(int senderId, int receiverId) {
//		super();
//		this.senderId = senderId;
//		this.receiverId = receiverId;
//		this.accepted = false;
//	}
//
//	public int getSenderId() {
//		return senderId;
//	}
//
//	public void setSenderId(int senderId) {
//		this.senderId = senderId;
//	}
//
//	public int getreceiverId() {
//		return receiverId;
//	}
//
//	public void setreceiverId(int receiverId) {
//		this.receiverId = receiverId;
//	}
//
//	public boolean isAccepted() {
//		return accepted;
//	}
//
//	public void setAccepted(boolean accepted) {
//		this.accepted = accepted;
//	}

}
