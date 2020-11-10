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

@Controller
@CrossOrigin
@RequestMapping
public class CommentController {

	private CommentService cs;
	
	public CommentService getCs() {
		return cs;
	}
	
	@Autowired
	public void setCs(CommentService cs) {
		this.cs = cs;
	}
	
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
