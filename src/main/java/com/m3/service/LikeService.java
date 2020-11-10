package com.m3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3.dao.LikeDao;
import com.m3.model.Like;

@Service
public class LikeService {

	private LikeDao ld;
	
	public LikeService() {
		super();
	}
	
	public LikeService(LikeDao ld) {
		super();
		this.ld = ld;
	}
	
	public LikeDao getLd() {
		return ld;
	}
	
	@Autowired
	public void setLd(LikeDao ld) {
		this.ld = ld;
	}
	
	public List<Like> getAllLikes(){
		return ld.findAll();
	}
	
	public Like getLikeById(Integer i) {
		return ld.findById(i);
	}
	
	public List<Like> getAllUserLikes(Integer i){
		return ld.findLikesForUser(i);
	}
	
	public List<Like> getAllPostLikes(Integer i){
		return ld.findLikesForPost(i);
	}
	
	public List<Like> getAllCommentLikes(Integer i){
		return ld.findLikesForComment(i);
	}
	
	public Like insertLikeService(Like l) {
		return ld.save(l);
	}
	public Like deleteLike(Like l) {
		return ld.delete(l.getId());
	}
	
}
