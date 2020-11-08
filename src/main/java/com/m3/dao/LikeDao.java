package com.m3.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.m3.model.Like;
import com.m3.util.HibernateUtil;

@Repository
@Transactional
public class LikeDao /*implements DaoContract<Like, Integer>*/{

	private SessionFactory sessfact;
	
	@Autowired
	public LikeDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}
	
	public LikeDao() {		
	}
	
	//@Override
	public List<Like> findAll() {
		List<Like> likes = sessfact.openSession().createQuery("from Like", Like.class).list();
		return likes;
	}

	//@Override
	public Like findById(Integer i) {
		Like l = sessfact.openSession().get(Like.class, i);
		return l;
	}

	public List<Like> findLikesForUser(Integer i){
		List<Like> list = sessfact.openSession().createQuery("from Like where authorid =" + i, Like.class).list();
		return list;
	}
	
	public List<Like> findLikesForPost(Integer i){
		List<Like> list = sessfact.openSession().createQuery("from Like where postid =" + i, Like.class).list();
		return list;
	}
	
	public List<Like> findLikesForComment(Integer i){
		List<Like> list = sessfact.openSession().createQuery("from Like where commentid =" + i, Like.class).list();
		return list;
	}
	
	//@Override
	public Like update(Like t) {
		sessfact.openSession().update(t);
		return t;
	}

	//@Override
	public Like save(Like t) {
		sessfact.openSession().save(t);
		return t;
	}

	//@Override
	public Like delete(Integer i) {
		Like l = findById(i);
		sessfact.openSession().delete(l);
		return l;
	}

}
