package com.m3.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.m3.model.User;
/**
 * 
 * <h1>UserDao</h1>
 * <p>
 * The user dao is how we access our user objects in the database. CRUD
 * operations for users and queries from the database are performed here.
 * 
 * </p>
 * <p>
 * This component uses annotations to indicate that it is a repository and that
 * it interacts with the database.
 * 
 * </p>
 * 
 * @authors Alex Orr, Enoch Cho, Jordan Hunnicutt, Robert Porto, Tyrone
 *          Veneracion
 *
 */
@Repository
@Transactional
public class UserDao /* implements DaoContract<User, Integer> */ {

	/**
	 * <p>
	 * Sessfact is an instance of the SessionFactory. This creates database sessions
	 * so we can interact with our database.
	 * </p>
	 */
	private SessionFactory sessfact;

	/**
	 * <p>
	 * The UserDao constructor is auto injected with an instance of the session
	 * factory.
	 * </p>
	 * 
	 * @param SessionFactory sessfact
	 * 
	 */
	@Autowired
	public UserDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	/**
	 * <p>
	 * The no-arg constructor is so we can create an instance of the UserDao
	 * without arguments.
	 * <p>
	 */
	public UserDao() {
	}

	/**
	 * <p>
	 * The findAll method gets all the users from the data base. The users are
	 * returned in a list.
	 * </p>
	 * 
	 * @return List<User> list
	 */
	public List<User> findAll() {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		List<User> list = session.createQuery("from User", User.class).list();
		trans.commit();
		return list;
	}

	/**
	 * 
	 * <p>
	 * The findById method gets a user in the database by its id.
	 * </p>
	 * 
	 * @param Integer i
	 * @return User u
	 */
	public User findById(Integer i) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		User u = session.get(User.class, i);
		trans.commit();
		return u;
	}

	/**
	 * 
	 * <p>
	 * The update method updates a user in the database and returns the java
	 * object.
	 * </p>
	 * 
	 * @param User t
	 * @return User t
	 */
	public User update(User t) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		session.merge(t);
		trans.commit();
		return t;
	}

	/**
	 * 
	 * <p>
	 * The save method saves a user in the database and returns the saved user.
	 * </p>
	 * 
	 * @param User t
	 * @return User t
	 */
	public User save(User t) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		return t;
	}

	/**
	 * 
	 * <p>
	 * The findByEmail method gets a user in the database by its email address.
	 * </p>
	 * 
	 * @param String email
	 * @return User u
	 */
	public User findByEmail(String email) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		User u = session.createQuery("from User where email='" + email + "'", User.class).list().get(0);
		trans.commit();
//		User ue = sessfact.openSession().get(User.class, email);
		return u;
	}

	/**
	 * 
	 * <p>
	 * The findByEmail method gets a user in the database by its email address and password.
	 * </p>
	 * 
	 * @param String email
	 * @param String password
	 * @return User u
	 */
	public User findByEmailAndPassword(String email, String password) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		User u = session
				.createQuery("from User where (email, password) = ('" + email + "', md5('"+email+"' ||'" + password + "'||'mailmailmail'))", User.class)
				.list().get(0);
		trans.commit();
		return u;
	}

}
