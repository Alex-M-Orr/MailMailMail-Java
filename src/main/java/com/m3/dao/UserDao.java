package com.m3.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.m3.model.User;
import com.m3.util.HibernateUtil;

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
		List<User> list = HibernateUtil.getSessionFactory().openSession().createQuery("from User", User.class).list();
		return list;
	}

//	@Override
	public User findById(Integer i) {
		User u = sessfact.openSession().get(User.class, i);
		return u;
	}

//	@Override
	public User update(User t) {
		sessfact.getCurrentSession().merge(t);
		return t;
	}

//	@Override
	public User save(User t) {
		sessfact.openSession().save(t);
		return t;
	}

	public User findByEmail(String email) {
		User u = HibernateUtil.getSessionFactory().openSession()
				.createQuery("from User where email='" + email + "'", User.class).list().get(0);
//		User ue = sessfact.openSession().get(User.class, email);
		return u;
	}

	public User findByEmailAndPassword(String email, String password) {
		User u = sessfact.openSession().createQuery("from User where (email, password) = ('"+email+"', '"+password+"')", User.class).list().get(0);
		return u;
	}
	
}
