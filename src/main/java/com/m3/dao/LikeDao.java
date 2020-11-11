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

@Repository
@Transactional
public class LikeDao /* implements DaoContract<Like, Integer> */ {

	private SessionFactory sessfact;

	@Autowired
	public LikeDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	public LikeDao() {
	}

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
