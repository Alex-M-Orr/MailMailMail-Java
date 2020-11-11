package com.m3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3.dao.LikeDao;
import com.m3.model.Like;
/**
 * 
 * <h1>LikeService</h1>
 * <p>The like service is used to pass information about a Like between the controller layer and the repository.</p>
 * <p>This component uses annotations to indicate that it is a service, and that it has connected beans.</p>
 * 
 * @authors Alex Orr, Enoch Cho, Jordan Hunnicutt, Robert Porto, Tyrone Veneracion
 *
 */
@Service
public class LikeService {

	/**
	 * This field is a LikeDao, which is a component used to communicate directly with the repository.
	 */
	private LikeDao ld;
	
	/**
	 * <p> This no argument constructor creates the LikeService.</p>
	 */
	public LikeService() {
		super();
	}
	
	/**
	 * <p> This constructor creates the LikeService and gives it an instance of a LikeDao.</p>
	 * 
	 * @param LikeDao ld
	 */
	public LikeService(LikeDao ld) {
		super();
		this.ld = ld;
	}
	
	/**
	 * <p>The getLd method retrieves the LikeDao field.</p>
	 * 
	 * @return LikeDao ld
	 */
	public LikeDao getLd() {
		return ld;
	}
	
	/**
	 * 
	 * <p>The setLd method sets the LikeDao field based on a LikeDao parameter.</p>
	 * The autowired tag is used so Spring creates a bean wiring to the LikeDao class.
	 * 
	 * @param LikeDao ld
	 */
	@Autowired
	public void setLd(LikeDao ld) {
		this.ld = ld;
	}
	
	/**
	 * <p>The getAllLikes method returns a list of Likes.</p>
	 * 
	 * @return List<Like> LikeDao.findAll()
	 */
	public List<Like> getAllLikes(){
		return ld.findAll();
	}
	
	/**
	 * <p>The getById method returns a Like based on a like's ID.</p>
	 * 
	 * @param Integer i
	 * @return Like LikeDao.findById(i)
	 */
	public Like getLikeById(Integer i) {
		return ld.findById(i);
	}
	
	/**
	 * <p>The getAllUserLikes method returns a list of Likes made by a user, using the user's ID.</p>
	 * 
	 * @param Integer i
	 * @return List<Like> LikeDao.findLikesForUser(i)
	 */
	public List<Like> getAllUserLikes(Integer i){
		return ld.findLikesForUser(i);
	}
	
	/**
	 * <p>The getAllUserLikes method returns a list of Likes on a post, using the post's ID.</p>
	 * 
	 * @param Integer i
	 * @return List<Like> LikeDao.findLikesForPost(i)
	 */
	public List<Like> getAllPostLikes(Integer i){
		return ld.findLikesForPost(i);
	}
	
	/**
	 * <p>The getAllUserLikes method returns a list of Likes on a comment, using the comment's ID.</p>
	 * 
	 * @param Integer i
	 * @return List<Like> LikeDao.findLikesForComment(i)
	 */
	public List<Like> getAllCommentLikes(Integer i){
		return ld.findLikesForComment(i);
	}
	
	/**
	 * <p>The insertLikeService method inserts a Like into the database, and returns the inserted Like.</p>
	 * 
	 * @param Like l
	 * @return Like LikeDao.save(l)
	 */
	public Like insertLikeService(Like l) {
		return ld.save(l);
	}
	
	/**
	 * <p>The deleteLike method deletes a Like from the database, and returns the deleted Like.</p>
	 * 
	 * @param Like l
	 * @return Like LikeDao.delete(l.getId())
	 */
	public Like deleteLike(Like l) {
		return ld.delete(l.getId());
	}
	
	/**
	 * <p>The deleteLikeService method deletes a Like from the database using its ID, and returns the deleted Like.</p>
	 * 
	 * @param Integer i
	 * @return Like LikeDao.delete(i)
	 */
	public Like deleteLikeService(Integer i) {
		return ld.delete(i);
	}
}
