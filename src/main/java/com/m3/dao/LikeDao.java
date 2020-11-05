package com.m3.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.m3.model.Like;
import com.m3.model.User;
import com.m3.util.HibernateUtil;

@Repository
public class LikeDao implements DaoContract<Like, Integer>{

	@Override
	public List<Like> findAll() {
		List<Like> likes = HibernateUtil.getSessionFactory().openSession()
			.createNativeQuery("select * from \"like\"", Like.class).list();
		return likes;
	}

	@Override
	public Like findById(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Like like = sess.get(Like.class, i);
		return like;
	}

	@Override
	public Like update(Like t) {
		
		return null;
	}

	@Override
	public Like save(Like t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public Like delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

}
