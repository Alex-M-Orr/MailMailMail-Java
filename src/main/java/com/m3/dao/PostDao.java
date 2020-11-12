package com.m3.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.m3.model.Post;
/**
 * 
 * <h1>PostDao</h1>
 * <p>
 * The post dao is how we access our post objects in the database. CRUD
 * operations for posts and queries from the database are performed here.
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
public class PostDao {
	
	/**
	 * <p>
	 * Sessfact is an instance of the SessionFactory. This creates database sessions
	 * so we can interact with our database.
	 * </p>
	 */
	private SessionFactory sessfact;

	/**
	 * <p>
	 * The PostDao constructor is auto injected with an instance of the session
	 * factory.
	 * </p>
	 * 
	 * @param SessionFactory sessfact
	 * 
	 */
	@Autowired()
	public PostDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	/**
	 * <p>
	 * The no-arg constructor is so we can create an instance of the PostDao
	 * without arguments.
	 * <p>
	 */
	public PostDao() {
	}

	/**
	 * <p>
	 * The findAll method gets all the posts from the data base. The posts are
	 * returned in a list.
	 * </p>
	 * 
	 * @return List<Post> list
	 */
	public List<Post> findAll() {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		List<Post> list = session.createQuery("from Post", Post.class).list();
		trans.commit();

		return list;
	}

	/**
	 * 
	 * <p>
	 * The findPostsForUser method gets all posts associated with a given user.
	 * </p>
	 * 
	 * <p>
	 * The user's id is given and a list of that user's posts is returned.
	 * </p>
	 * 
	 * @param Integer i
	 * @return List<Post> list
	 */
	public List<Post> findPostsForUser(Integer i) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		List<Post> list = session.createQuery("from Post where user_id =" + i, Post.class).list();
		trans.commit();
		return list;

	}

	/**
	 * 
	 * <p>
	 * The findById method gets a post in the database by its id.
	 * </p>
	 * 
	 * @param Integer i
	 * @return Post p
	 */
	public Post findById(Integer i) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		Post p = session.get(Post.class, i);
		trans.commit();
		return p;
	}

	/**
	 * 
	 * <p>
	 * The update method updates a post in the database and returns the java
	 * object.
	 * </p>
	 * 
	 * @param Post t
	 * @return Post t
	 */
	public Post update(Post t) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		return t;
	}

	/**
	 * 
	 * <p>
	 * The save method saves a post in the database and returns the saved post.
	 * </p>
	 * 
	 * @param Post t
	 * @return Post t
	 */
	public Post save(Post t) {
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

}
