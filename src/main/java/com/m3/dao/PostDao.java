package com.m3.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.m3.model.Post;
import com.m3.util.HibernateUtil;
@Repository
public class PostDao implements DaoContract<Post, Integer>{

	@Override
	public List<Post> findAll() {
		List<Post> posts = HibernateUtil.getSessionFactory().openSession().createNativeQuery("select * from post", Post.class).list();
		return posts;
	}

	@Override
	public Post findById(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();		
		return sess.createQuery("from post where id = "+i, Post.class).list().get(0);
	}

	@Override
	public Post update(Post t) {
		Session sess = HibernateUtil.getSessionFactory().openSession();		
		Transaction tx = sess.beginTransaction();
		sess.update(t);
		tx.commit();
		
		return t;
	}

	@Override
	public Post save(Post t) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = sess.beginTransaction();
		sess.save(t);
		tx.commit();
		return t;
	}

	@Override
	public Post delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

}
