package com.m3.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.m3.model.Comment;
import com.m3.model.User;
import com.m3.util.HibernateUtil;

public class CommentDao implements DaoContract<Comment, Integer> {

	@Override
	public List<Comment> findAll() {
		List<Comment> list = HibernateUtil.getSessionFactory().openSession()
				.createNativeQuery("select * from \"comment\"", Comment.class).list();
		return list;
	}

	@Override
	public Comment findById(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Comment c = sess.get(Comment.class, i);
		return c;
	}

	@Override
	public Comment update(Comment t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Comment save(Comment t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public Comment delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

}
