package com.m3.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.m3.model.Post;
import com.m3.util.HibernateUtil;

@Repository
public class PostDao implements DaoContract<Post, Integer> {

	@Override
	public List<Post> findAll() {
<<<<<<< HEAD
		List<Post> posts = HibernateUtil.getSessionFactory().openSession().createNativeQuery("select * from \"post\"", Post.class).list();
=======
		List<Post> posts = HibernateUtil.getSessionFactory().openSession()
				.createNativeQuery("select * from post", Post.class).list();
>>>>>>> 94bd07dea791de20bd49f497f14e88d2bcb06f53
		return posts;
	}

	@Override
	public Post findById(Integer i) {
		Session sess = HibernateUtil.getSessionFactory().openSession();
		Post p = sess.get(Post.class, i);
		return p;
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
