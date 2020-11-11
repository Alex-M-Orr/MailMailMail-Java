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

@Repository
@Transactional
public class PostDao {
	private SessionFactory sessfact;

	@Autowired()
	public PostDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	public PostDao() {
	}

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

//	@Override
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
