package com.m3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3.dao.UserDao;
import com.m3.model.User;

@Service
public class UserService {
	private UserDao ud;

	public UserDao getUd() {
		return ud;
	}

	@Autowired
	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	public List<User> findAll() {
		return ud.findAll();
	}

	public User findById(Integer i) {
		return ud.findById(i);
	}

	public User findByEmail(String email) {
		return ud.findByEmail(email);
	}

	public User update(User t) {
		return ud.update(t);
	}

	public User save(User t) {
		return ud.save(t);
	}

	public List<User> getAllUsers() {
		return ud.findAll();
	}

	public User getUser(Integer id) {
		return ud.findById(id);
	}
}
