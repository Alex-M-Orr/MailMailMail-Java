package com.m3.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.m3.model.Like;

/**
 * 
 * <h1>LikeDao</h1>
 * <p>
 * The comment dao is how we access our like objects in the database. CRUD
 * operations for likes and queries from the database are performed here.
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
public class LikeDao /* implements DaoContract<Like, Integer> */ {
	/**
	 * <p>
	 * Sessfact is an instance of the SessionFactory. This creates database sessions
	 * so we can interact with our database.
	 * </p>
	 */
	private SessionFactory sessfact;

	/**
	 * <p>
	 * The LikeDao constructor is auto injected with an instance of the session
	 * factory.
	 * </p>
	 * 
	 * @param sessfact
	 * 
	 */
	@Autowired
	public LikeDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	/**
	 * <p>
	 * The no-arg constructor is so we can create an instance of the CommentDao
	 * without arguments.
	 * <p>
	 */
	public LikeDao() {
	}

	/**
	 * <p>
	 * The findAll method gets all the likes from the data base. The likess are
	 * returned in a list.
	 * </p>
	 * 
	 * @return List<Like> likes
	 */

	// @Override
	public List<Like> findAll() {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		List<Like> likes = session.createQuery("from Like", Like.class).list();
		trans.commit();
		return likes;
	}

	/**
	 * 
	 * <p>
	 * The findById method gets a like in the database by it's id.
	 * </p>
	 * 
	 * @param i
	 * @return Like l
	 */

	// @Override
	public Like findById(Integer i) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		Like l = session.get(Like.class, i);
		trans.commit();
		return l;
	}

	/**
	 * 
	 * <p>
	 * The findLikesForUser method gets all likes associated with a given user.
	 * </p>
	 * 
	 * <p>
	 * The user's id is given and a list of that user's likes is returned
	 * </p>
	 * 
	 * @param i
	 * @return List<Like> list
	 */

	public List<Like> findLikesForUser(Integer i) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		List<Like> list = session.createQuery("from Like where authorid =" + i, Like.class).list();
		trans.commit();
		return list;
	}

	/**
	 * 
	 * <p>
	 * The findLikesForPost method gets all likes associated with a given post.
	 * 
	 * </p>
	 * 
	 * <p>
	 * The post's id is used and a list of all the likes associated with that post
	 * are returned
	 * </p>
	 * 
	 * @param i
	 * @return List<Like> list
	 */

	public List<Like> findLikesForPost(Integer i) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		List<Like> list = session.createQuery("from Like where postid =" + i, Like.class).list();
		trans.commit();
		return list;
	}

	/**
	 * 
	 * <p>
	 * The findLikesForComment method gets all likes associated with a given
	 * comment.
	 * 
	 * </p>
	 * 
	 * <p>
	 * The comment's id is used and a list of all the likes associated with that
	 * comment are returned
	 * </p>
	 * 
	 * @param i
	 * @return List<Like> list
	 */

	public List<Like> findLikesForComment(Integer i) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		List<Like> list = session.createQuery("from Like where commentid =" + i, Like.class).list();
		trans.commit();
		return list;
	}

	/**
	 * 
	 * <p>
	 * The save method saves a like in the database and returns the saved like.
	 * </p>
	 * 
	 * @param t
	 * @return Like t
	 */

	// @Override
	public Like save(Like t) {
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
	 * @return Like l
	 */

	// @Override
	public Like delete(Integer i) {

		Like l = findById(i);
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		session.delete(l);
		trans.commit();
		return l;
	}

}
