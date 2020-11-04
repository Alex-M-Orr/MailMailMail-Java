package com.m3.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.m3.model.User;
import com.m3.util.HibernateUtil;

public class UserDao implements DaoContract<User, Integer> {

	@Override
	public List<User> findAll() {
		List<User> list = HibernateUtil.getSessionFactory().openSession()
				.createNativeQuery("select * from \"user\"", User.class).list();
		return list;
	}

	@Override
	public User findById(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User update(User t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User save(User t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public User delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

}
