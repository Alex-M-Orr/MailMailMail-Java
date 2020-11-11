package com.m3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3.dao.CommentDao;
import com.m3.model.Comment;
/**
 * 
 * <h1>CommentService</h1>
 * <p>The comment service is used to pass information about a comment between the controller layer and the repository.</p>
 * <p>This component uses annotations to indicate that it is a service, and that it has connected beans.</p>
 * 
 * @authors Alex Orr, Enoch Cho, Jordan Hunnicutt, Robert Porto, Tyrone Veneracion
 *
 */
@Service
public class CommentService {

	/**
	 * This field is a CommentDao, which is a component used to communicate directly with the repository.
	 */
	private CommentDao cd;
	
	/**
	 * <p> This no argument constructor creates the CommentService.</p>
	 */
	public CommentService() {
		super();
	}
	
	/**
	 * <p> This constructor creates the CommentService and gives it an instance of a CommentDao.</p>
	 * 
	 * @param CommentDao cd
	 */
	public CommentService(CommentDao cd) {
		super();
		this.cd = cd;
	}
	
	/**
	 * <p>The getCd method retrieves the CommentDao field.</p>
	 * 
	 * @return CommentDao cd
	 */
	public CommentDao getCd() {
		return cd;
	}
	
	/**
	 * 
	 * <p>The setCd method sets the CommentDao field based on a CommentDao parameter.</p>
	 * The autowired tag is used so Spring creates a bean wiring to the CommentDao class.
	 * 
	 * @param CommentDao cd
	 */
	@Autowired
	public void setCd(CommentDao cd) {
		this.cd = cd;
	}
	
	/**
	 * <p>The getAllComments method returns a list of Comments.</p>
	 * 
	 * @return List<Comment> CommentDao.findAll()
	 */
	public List<Comment> getAllComments(){
		return cd.findAll();
	}
	
	/**
	 * <p>The getById method returns a Comment based on a comment's ID.</p>
	 * 
	 * @param Integer i
	 * @return Comment CommentDao.findById(i)
	 */
	public Comment getById(Integer i) {
		return cd.findById(i);
	}
	
	/**
	 * <p>The getAllUserComments method returns a list of Comments made by a user, using the user's ID.</p>
	 * 
	 * @param Integer i
	 * @return List<Comment> CommentDao.findCommentsForUser(i)
	 */
	public List<Comment> getAllUserComments(Integer i){
		return cd.findCommentsForUser(i);
	}
	
	/**
	 * <p>The getAllUserComments method returns a list of Comments on a post, using the post's ID.</p>
	 * 
	 * @param Integer i
	 * @return List<Comment> CommentDao.findCommentsForPost(i)
	 */
	public List<Comment> getAllPostComments(Integer i){
		return cd.findCommentsForPost(i);
	}
	
	/**
	 * <p>The insertCommentService method inserts a Comment into the database, and returns the inserted Comment.</p>
	 * 
	 * @param Comment c
	 * @return Comment CommentDao.save(c)
	 */
	public Comment insertCommentService(Comment c) {
		return cd.save(c);
	}
	
	/**
	 * <p> The updateCommentService method updates a Comment in the database, and returns the updated Comment.</p>
	 * 
	 * @param Comment c
	 * @return Comment CommentDao.update(c)
	 */
	public Comment updateCommentService(Comment c) {
		return cd.update(c);
	}
}
