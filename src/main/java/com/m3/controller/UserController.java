package com.m3.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m3.model.User;
import com.m3.model.UserBuilt;
import com.m3.service.MailService;
import com.m3.service.UserService;

/**
 * 
 * <h1>UserController</h1>
 * <p>
 * The user controller is used to get information about the user from the front
 * end based on different request mappings.
 * </p>
 * <p>
 * This component uses annotations to indicate that it is a controller, that it
 * uses cross origin references, that it has request mappings, and that it has
 * connected beans
 * </p>
 * 
 * @authors Alex Orr, Enoch Cho, Jordan Hunnicutt, Robert Porto, Tyrone
 *          Veneracion
 *
 */
@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping
public class UserController {
	/**
	 * This field is a UserService, which is a component used to communicate between
	 * this controller and the repository.
	 */
	private UserService us;
	/**
	 * This field is a MailService, which is a component used to send email.
	 */
	private MailService ms;

	/**
	 * <p>
	 * The getUs method retrieves the UserService field.
	 * </p>
	 * 
	 * @return UserService us
	 */
	public UserService getUs() {
		return us;
	}

	/**
	 * 
	 * <p>
	 * The setUs method sets the UserService field based on a UserService parameter.
	 * </p>
	 * The autowired tag is used so Spring creates a bean wiring to the UserService
	 * class.
	 * 
	 * @param UserService us
	 */
	@Autowired
	public void setUs(UserService us) {
		this.us = us;
	}

	/**
	 * <p>
	 * The getMs method retrieves the MailService field.
	 * </p>
	 * 
	 * @return MailService ms
	 */
	public MailService getMs() {
		return ms;
	}

	/**
	 * 

	 * <p>The setMs method sets the MailService field based on a MailService parameter.</p>
	 * 
	 * @param MailService ms
	 */
	public void setMs(MailService ms) {
		this.ms = ms;
	}
	
	/**
	 * <p>
	 * The getAll method returns a list of UserBuilts.
	 * </p>
	 * It gets a list of Users from the database and rebuilds them into a format
	 * that can be more easily returned.
	 * 
	 * @return List<UserBuilt> builtUsers
	 */
	@GetMapping("/userAll.app")
	public @ResponseBody List<UserBuilt> getAll() {
		List<User> users = us.findAll();
		List<UserBuilt> builtUsers = new LinkedList<>();
		for (User u : users) {
			builtUsers.add(new UserBuilt(u));
		}

		return builtUsers;
	}

	/**
	 * <p>
	 * The getUser method returns a UserBuilt based on a user's ID.
	 * </p>
	 * It gets a User from the database and rebuilds it into a format that can be
	 * more easily returned.
	 * 
	 * @param Integer id
	 * @return UserBuilt builtUser
	 */
	@GetMapping("/user.app")
	public @ResponseBody UserBuilt getUser(@RequestParam Integer id) {
		User user = us.findById(id);
		UserBuilt builtUser = new UserBuilt(user);
		return builtUser;
	}

	/**
	 * <p>
	 * The getUserByEmail method returns a UserBuilt based on a user's email.
	 * </p>
	 * It gets a User from the database and rebuilds it into a format that can be
	 * more easily returned.
	 * 
	 * @param String email
	 * @return UserBuilt builtUser
	 */
	@GetMapping("/userByEmail.app")
	public @ResponseBody UserBuilt getUserByEmail(@RequestParam String email) {
		User user = us.findByEmail(email);
		UserBuilt builtUser = new UserBuilt(user);
		return builtUser;
	}

	/**
	 * 
	 * <p>
	 * The createUser method saves a User to a database, then returns that user
	 * </p>
	 * 
	 * @param User user
	 * @return User user
	 */
	@PostMapping("/createUser.app")
	public @ResponseBody UserBuilt createUser(@RequestBody UserBuilt user) {
		User u = new User(user);
		us.save(u);
		return user;
	}

	/**
	 * 
	 * <p>
	 * The updateUser method updates a User on the database, then returns the
	 * updated user.
	 * </p>
	 * 
	 * @param User user
	 * @return User user
	 */
	@PutMapping("/updateUser.app")
	public @ResponseBody UserBuilt updateUser(@RequestBody UserBuilt user) {
		User u = us.findById(user.getId());
		try {
			u.setEmail(user.getEmail());
		} catch (Exception e) {}
		try {
			u.setPassword(user.getPassword());
		} catch (Exception e) {}
		try {
			u.setFirstName(user.getFirstName());
		} catch (Exception e) {}
		try {
			u.setLastName(user.getLastName());
		} catch (Exception e) {}
		try {
			u.setPhoto(user.getPhoto());
		} catch (Exception e) {}
		us.update(u);
		return user;
	}

	/**
	 * <p>
	 * The loginUser method selects a User from the database based on an email and a
	 * password.
	 * </p>
	 * It gets a User from the database and rebuilds it into a format that can be
	 * more easily returned.
	 * 
	 * @param String email
	 * @param String password
	 * @return UserBuilt builtUser
	 */
	@PostMapping("/login.app")
	public @ResponseBody UserBuilt loginUser(@RequestParam String email, @RequestParam String password) {
		User user = us.findByEmailAndPassword(email, password);
		UserBuilt builtUser = new UserBuilt(user);
		return builtUser;
	}

	/**
	 * <p>
	 * The sendEmail method sends an email to the provided address
	 * </p>
	 * 
	 * @param String email
	 */

	@PostMapping("/forgotPass.app")
	public void sendEmail(@RequestParam String email){
		ms = new MailService();
		ms.sendMessage(email);
	}
	
}
