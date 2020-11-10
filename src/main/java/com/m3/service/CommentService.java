package com.m3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3.dao.CommentDao;
import com.m3.model.Comment;

@Service
public class CommentService {

	private CommentDao cd;
	
	public CommentService() {
		super();
	}
	
	public CommentService(CommentDao cd) {
		super();
		this.cd = cd;
	}
	
	public CommentDao getCd() {
		return cd;
	}
	
	@Autowired
	public void setCd(CommentDao cd) {
		this.cd = cd;
	}
	
	public List<Comment> getAllComments(){
		return cd.findAll();
	}
	
	public Comment getById(Integer i) {
		return cd.findById(i);
	}
	
	public List<Comment> getAllUserComments(Integer i){
		return cd.findCommentsForUser(i);
	}
	
	public List<Comment> getAllPostComments(Integer i){
		return cd.findCommentsForPost(i);
	}
	
	public Comment insertCommentService(Comment c) {
		return cd.save(c);
	}
	
	public Comment updateCommentService(Comment c) {
		return cd.update(c);
	}
}
