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

@Repository
@Transactional
public class UserDao /* implements DaoContract<User, Integer> */ {

	private SessionFactory sessfact;

	@Autowired
	public UserDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	public UserDao() {
	}

//	@Override
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

//	@Override
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

//	@Override
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

//	@Override
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

	public User findByEmailAndPassword(String email, String password) {
		Session session;
		try {
			session = sessfact.getCurrentSession();
		} catch (HibernateException e) {
			session = sessfact.openSession();
		}
		Transaction trans = session.beginTransaction();
		User u = session
				.createQuery("from User where (email, password) = ('" + email + "', '" + password + "')", User.class)
				.list().get(0);
		trans.commit();
		return u;
	}

}
