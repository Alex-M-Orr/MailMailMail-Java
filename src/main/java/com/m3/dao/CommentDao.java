package com.m3.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.m3.model.Comment;

@Repository
@Transactional
public class CommentDao /* implements DaoContract<Comment, Integer> */ {

	private SessionFactory sessfact;

	@Autowired
	public CommentDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	public CommentDao() {
	}

	// @Override
	public List<Comment> findAll() {
		Session session = sessfact.getCurrentSession();
		Transaction trans = session.beginTransaction();
		List<Comment> comments = session.createQuery("from Comment", Comment.class).list();
		trans.commit();
		return comments;
	}

	// @Override
	public Comment findById(Integer i) {
		Session session = sessfact.getCurrentSession();
		Transaction trans = session.beginTransaction();
		Comment c = session.get(Comment.class, i);
		trans.commit();
		return c;
	}

	public List<Comment> findCommentsForUser(Integer i) {
		Session session = sessfact.getCurrentSession();
		Transaction trans = session.beginTransaction();
		List<Comment> list = session.createQuery("from Comment where authorid = " + i, Comment.class).list();
		trans.commit();
		return list;
	}

	public List<Comment> findCommentsForPost(Integer i) {
		Session session = sessfact.getCurrentSession();
		Transaction trans = session.beginTransaction();
		List<Comment> list = session.createQuery("from Comment where postid = " + i, Comment.class).list();
		trans.commit();
		return list;
	}

	// @Override
	public Comment update(Comment t) {
		Session session = sessfact.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.update(t);
		trans.commit();
		return t;
	}

	// @Override
	public Comment save(Comment t) {
		Session session = sessfact.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.save(t);
		trans.commit();
		return t;
	}

	// @Override
	public Comment delete(Integer i) {
		Comment c = findById(i);

		Session session = sessfact.getCurrentSession();
		Transaction trans = session.beginTransaction();
		session.delete(c);
		trans.commit();
		return c;
	}

}
