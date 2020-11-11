package com.m3.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m3.model.Comment;
import com.m3.model.CommentBuilt;
import com.m3.service.CommentService;
/**
 * 
 * <h1>CommentController</h1>
 * <p>The comment controller is used to get information about a comment from the front end based on different request mappings.</p>
 * <p>This component uses annotations to indicate that it is a controller, that it uses cross origin references, that it has request mappings, and that it has connected beans</p>
 * 
 * @authors Alex Orr, Enoch Cho, Jordan Hunnicutt, Robert Porto, Tyrone Veneracion
 *
 */
@Controller
@CrossOrigin
@RequestMapping
public class CommentController {
	/**
	 * This field is a CommentService, which is a component used to communicate between this controller and the repository.
	 */
	private CommentService cs;
	
	/**
	 * <p>The getLs method retrieves the CommentService field.</p>
	 * 
	 * @return CommentService cs
	 */
	public CommentService getCs() {
		return cs;
	}
	
	/**
	 * 
	 * <p>The setCs method sets the CommentService field based on a CommentService parameter.</p>
	 * The autowired tag is used so Spring creates a bean wiring to the CommentService class.
	 * 
	 * @param CommentService cs
	 */
	@Autowired
	public void setCs(CommentService cs) {
		this.cs = cs;
	}
	
	/**
	 * <p>The getAll method returns a list of CommentBuilts.</p>
	 * It gets a list of Comments from the database and rebuilds them into a format that can be more easily returned.
	 * 
	 * @return List<CommentBuilt> builtComments
	 */
	@GetMapping("/commentAll.app")
	public @ResponseBody List<CommentBuilt> getAll(){
		List<Comment> comments = cs.getAllComments();
		List<CommentBuilt> builtComments = new LinkedList<>();
		for(Comment c : comments) {
			builtComments.add(new CommentBuilt(c));
		}
		return builtComments;
	}
	
	@GetMapping("/commentById.app")
	public @ResponseBody CommentBuilt getById(@RequestParam Integer id) {
		Comment comment = cs.getById(id);
		CommentBuilt builtComment = new CommentBuilt(comment);
		return builtComment;
	}
	
	@GetMapping("/commentAUser.app")
	public @ResponseBody List<CommentBuilt> getAllCommentsByUser(@RequestParam Integer id){
		List<Comment> comments = cs.getAllUserComments(id);
		List<CommentBuilt> builtComments = new LinkedList<>();
		for(Comment c : comments) {
			builtComments.add(new CommentBuilt(c));
		}
		return builtComments;
	}
	
	@GetMapping("/commentAPost.app")
	public @ResponseBody List<CommentBuilt> getAllCommentsByPost(@RequestParam Integer id){
		List<Comment> comments = cs.getAllPostComments(id);
		List<CommentBuilt> builtComments = new LinkedList<>();
		for(Comment c : comments) {
			builtComments.add(new CommentBuilt(c));
		}
		return builtComments;
	}
	
	@PostMapping("/insertComment.app")
	public void insertComment(@RequestBody Comment comment) {
		Comment c = new Comment();
		
		c.setId(comment.getId());
		c.setContent(comment.getContent());
		c.setPost(comment.getPost());
		c.setAuthor(comment.getAuthor());
		c.setDateCreated(comment.getDateCreated());
		
		cs.insertCommentService(c);
	}
	
	@PostMapping("/updateComment.app")
	public void updateComment(@RequestBody Comment comment) {
		Comment c = cs.getById(comment.getId());
		
		c.setId(comment.getId());
		c.setContent(comment.getContent());
		c.setPost(comment.getPost());
		c.setAuthor(comment.getAuthor());
		c.setDateCreated(comment.getDateCreated());
		
		cs.updateCommentService(c);
	}
	
}
