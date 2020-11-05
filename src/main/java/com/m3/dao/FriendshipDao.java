package com.m3.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.m3.model.Friendship;
import com.m3.util.HibernateUtil;

@Repository
public class FriendshipDao implements DaoContract<Friendship, Integer>{

	@Override
	public List<Friendship> findAll() {
		List<Friendship>list = HibernateUtil.getSessionFactory().openSession().createQuery("from Friendship", Friendship.class).list();
		return list;
	}

	@Override
	public Friendship findById(Integer i) {
		Friendship f = HibernateUtil.getSessionFactory()
				.openSession()
				.createQuery("from Friendship where senderId ="+i, Friendship.class)
				.list().get(0);
		Friendship f2 = HibernateUtil.getSessionFactory()
				.openSession()
				.createQuery("from Friendship where receiverId ="+i, Friendship.class)
				.list().get(0);
		try {
			boolean b = f.equals(null);
			return f;
		} catch(NullPointerException e) {
			try {
				boolean b2 = f2.equals(null);
				return f2;
			} catch(NullPointerException e2) {
				
			}
		}
		return null;
	}
	
	
	@Override
	public Friendship update(Friendship t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.update(t);
		tx.commit();
		return null;
	}

	@Override
	public Friendship save(Friendship t) {
		SessionFactory sesfact = HibernateUtil.getSessionFactory();
		Session sess = sesfact.openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public Friendship delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

}
