package com.m3.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m3.model.User;
import com.m3.model.UserBuilt;
import com.m3.service.UserService;

@Controller
@CrossOrigin
@RequestMapping
public class UserController {
	private UserService us;

	public UserService getUs() {
		return us;
	}

	@Autowired
	public void setUs(UserService us) {
		this.us = us;
	}

	@GetMapping("/userAll.app")
	public @ResponseBody List<UserBuilt> getAll() {
		List<User> users = us.getAllUsers();
		List<UserBuilt> builtUsers = new LinkedList<>();
		for (User u : users) {
			builtUsers.add(new UserBuilt(u));
		}

		return builtUsers;
	}

	@GetMapping("/user.app")
	public @ResponseBody UserBuilt getUser(@RequestParam Integer id) {
		User user = us.getUser(id);
		UserBuilt builtUser = new UserBuilt(user);
		return builtUser;
	}

	@GetMapping("/userByEmail.app")
	public @ResponseBody UserBuilt getUserByEmail(@RequestParam String email) {
		User user = us.findByEmail(email);
		UserBuilt builtUser = new UserBuilt(user);
		return builtUser;
	}

//	@GetMapping
//	public @ResponseBody List<String> getAll() {
//		return ps.getAllPostsString();
//
//	}

}
