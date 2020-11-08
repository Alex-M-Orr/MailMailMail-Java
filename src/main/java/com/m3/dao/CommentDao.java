package com.m3.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.m3.model.Comment;

@Repository
@Transactional
public class CommentDao /*implements DaoContract<Comment, Integer>*/{

	private SessionFactory sessfact;
	
	@Autowired
	public CommentDao(SessionFactory sessfact) {
		this.sessfact = sessfact;
	}
	
	public CommentDao() {
	}
	
	//@Override
	public List<Comment> findAll() {
		List<Comment> comments = sessfact.openSession().createQuery("from Comment", Comment.class).list();
		return comments;
	}

	//@Override
	public Comment findById(Integer i) {
		Comment c = sessfact.openSession().get(Comment.class, i);
		return c;
	}

	public List<Comment> findCommentsForUser(Integer i){
		List<Comment> list = sessfact.openSession().createQuery("from Comment where authorid = "+i, Comment.class).list();
		return list;
	}
	
	public List<Comment> findCommentsForPost(Integer i){
		List<Comment> list = sessfact.openSession().createQuery("from Comment where postid = "+i, Comment.class).list();
		return list;
	}
	
	//@Override
	public Comment update(Comment t) {
		sessfact.openSession().update(t);
		return t;
	}

	//@Override
	public Comment save(Comment t) {
		sessfact.openSession().save(t);
		return t;
	}

	//@Override
	public Comment delete(Integer i) {
		Comment c = findById(i);
		sessfact.openSession().delete(c);
		return c;
	}

}
