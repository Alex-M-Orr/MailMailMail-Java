package com.m3.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.m3.model.Post;
import com.m3.model.User;
import com.m3.util.HibernateUtil;

@Repository
@Transactional
public class PostDao {
	private SessionFactory sessfact;

	@Autowired
	public PostDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}

	public PostDao() {
	}

	public List<Post> findAll() {
		List<Post> list = HibernateUtil.getSessionFactory().openSession().createQuery("from Post", Post.class).list();
		return list;
	}

	public Post findById(Integer i) {
		Post p = sessfact.openSession().get(Post.class, i);
		return p;
	}

	public Post update(Post t) {
		sessfact.openSession().update(t);
		return t;
	}

//	@Override
	public Post save(Post t) {
		sessfact.openSession().save(t);
		return t;
	}

//	@Override
	public User delete(Integer i) {
		// TODO Auto-generated method stub
		return null;
	}

//	public User findByEmail(String email) {
////		User u = HibernateUtil.getSessionFactory().openSession()
////				.createQuery("from User where email='"+ email +"'", User.class).list().get(0);
//		User ue = sessfact.openSession().get(User.class, email);
//		return ue;
//	}

//	@Override
//	public Post save(Post t) {
//		Session sess = HibernateUtil.getSessionFactory().openSession();
//		Transaction tx = sess.beginTransaction();
//		sess.save(t);
//		tx.commit();
//		return t;
//	}

}
