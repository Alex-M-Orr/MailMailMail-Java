package com.m3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3.dao.UserDao;
import com.m3.model.User;
/**
 * 
 * <h1>UserService</h1>
 * <p>The user service is used to pass information about a User between the controller layer and the repository.</p>
 * <p>This component uses annotations to indicate that it is a service, and that it has connected beans.</p>
 * 
 * @authors Alex Orr, Enoch Cho, Jordan Hunnicutt, Robert Porto, Tyrone Veneracion
 *
 */
@Service
public class UserService {
	
	/**
	 * This field is a UserDao, which is a component used to communicate directly with the repository.
	 */
	private UserDao ud;

	/**
	 * <p>The getUd method retrieves the UserDao field.</p>
	 * 
	 * @return UserDao ud
	 */
	public UserDao getUd() {
		return ud;
	}

	/**
	 * 
	 * <p>The setUd method sets the UserDao field based on a UserDao parameter.</p>
	 * The autowired tag is used so Spring creates a bean wiring to the UserDao class.
	 * 
	 * @param UserDao ud
	 */
	@Autowired
	public void setUd(UserDao ud) {
		this.ud = ud;
	}

	/**
	 * <p>The findAll method returns a list of Users.</p>
	 * 
	 * @return List<User> UserDao.findAll()
	 */
	public List<User> findAll() {
		return ud.findAll();
	}

	/**
	 * <p>The findById method returns a User based on a user's ID.</p>
	 * 
	 * @param Integer i
	 * @return User UserDao.findById(i)
	 */
	public User findById(Integer i) {
		return ud.findById(i);
	}

	/**
	 * <p>The findByEmail method returns a User based on a user's email address.</p>
	 * 
	 * @param String email
	 * @return User UserDao.findByEmail(email)
	 */
	public User findByEmail(String email) {
		return ud.findByEmail(email);
	}

	/**
	 * <p>The findByEmailAndPassword method returns a User based on a user's email address and password.</p>
	 * 
	 * @param String email
	 * @param String password
	 * @return User UserDao.findByEmailAndPassword(email, password)
	 */
	public User findByEmailAndPassword(String email, String password) {
		return ud.findByEmailAndPassword(email, password);
	}
	
	/**
	 * <p>The update method updates a User in the database, then returns the updated User.</p>
	 * 
	 * @param User u
	 * @return User UserDao.update(u)
	 */
	public User update(User u) {
		return ud.update(u);
	}

	/**
	 * <p>The save method inserts a User into the database, then returns the inserted User.</p>
	 * 
	 * @param User u
	 * @return User UserDao.save(u)
	 */
	public User save(User u) {
		return ud.save(u);
	}
}
