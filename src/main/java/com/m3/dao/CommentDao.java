package com.m3.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.m3.model.Comment;

/**
 * 
 * <h1>CommentDao</h1>
 * <p>
 * The comment dao is how we access our comment objects in the database. CRUD
 * operations for comments and queries fromm the database are performed here.
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
public class CommentDao /* implements DaoContract<Comment, Integer> */ {

	/**
	 * <p>
	 * Sessfact is an instance of the SessionFactory. This creates database sessions
	 * so we can interact with our database.
	 * </p>
	 */
	private SessionFactory sessfact;

	/**
	 * <p>
	 * The CommentDao constructor is auto injected with an instance of the session
	 * factory.
	 * </p>
	 * 
	 * @param sessfact
	 * 
	 */
	@Autowired
	public CommentDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	/**
	 * <p>
	 * The no-arg constructor is so we can create an instance of the CommentDao
	 * without arguments.
	 * <p>
	 */
	public CommentDao() {
	}

	/**
	 * <p>
	 * The findAll method gets all the comments from the data base. The comments are
	 * returned in a list.
	 * </p>
	 * 
	 * @return List<Comment> comments
	 */
	// @Override
	public List<Comment> findAll() {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		List<Comment> comments = session.createQuery("from Comment", Comment.class).list();
		trans.commit();
		return comments;
	}

	/**
	 * 
	 * <p>
	 * The findById method gets a comment in the database by it's id.
	 * </p>
	 * 
	 * @param i
	 * @return Comment c
	 */

	// @Override
	public Comment findById(Integer i) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		Comment c = session.get(Comment.class, i);
		trans.commit();
		return c;
	}

	/**
	 * 
	 * <p>
	 * The findCommentsForUser method gets all comments associated with a given
	 * user.
	 * </p>
	 * 
	 * <p>
	 * The user's id is given and a list of that user's comments is returned
	 * </p>
	 * 
	 * @param i
	 * @return List<Comment> list
	 */

	public List<Comment> findCommentsForUser(Integer i) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		List<Comment> list = session.createQuery("from Comment where authorid = " + i, Comment.class).list();
		trans.commit();
		return list;
	}

	/**
	 * 
	 * <p>
	 * The findCommentsForPost method gets all comments associated with a given
	 * post.
	 * 
	 * </p>
	 * 
	 * <p>
	 * The post's id is used and a list of all the comments associated with that
	 * post are returned
	 * </p>
	 * 
	 * @param i
	 * @return List<Comment> list
	 */

	public List<Comment> findCommentsForPost(Integer i) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		List<Comment> list = session.createQuery("from Comment where postid = " + i, Comment.class).list();
		trans.commit();
		return list;
	}

	/**
	 * 
	 * <p>
	 * The update method updates a comment in the database and returns the updated
	 * comment.
	 * </p>
	 * 
	 * @param t
	 * @return Comment t
	 */
	// @Override
	public Comment update(Comment t) {
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
	 * The save method saves a comment in the database and returns the saved
	 * comment.
	 * </p>
	 * 
	 * @param t
	 * @return Comment t
	 */

	// @Override
	public Comment save(Comment t) {
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
	 * The delete method deletes a comment from the database and returns the java
	 * object.
	 * </p>
	 * 
	 * @param i
	 * @return Comment c
	 */
	// @Override
	public Comment delete(Integer i) {
		Comment c = findById(i);
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		session.delete(c);
		trans.commit();
		return c;
	}

}
