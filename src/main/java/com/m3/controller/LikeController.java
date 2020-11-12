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

import com.m3.model.Like;
import com.m3.model.LikeBuilt;
import com.m3.service.LikeService;
/**
 * 
 * <h1>LikeController</h1>
 * <p>The like controller is used to get information about a like from the front end based on different request mappings.</p>
 * <p>This component uses annotations to indicate that it is a controller, that it uses cross origin references, that it has request mappings, and that it has connected beans</p>
 * 
 * @authors Alex Orr, Enoch Cho, Jordan Hunnicutt, Robert Porto, Tyrone Veneracion
 *
 */
@Controller
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping
public class LikeController {
	/**
	 * This field is a LikeService, which is a component used to communicate between this controller and the repository.
	 */
	private LikeService ls;
	
	/**
	 * <p>The getLs method retrieves the LikeService field.</p>
	 * 
	 * @return LikeService ls
	 */
	public LikeService getLs() {
		return ls;
	}
	
	/**
	 * 
	 * <p>The setLs method sets the LikeService field based on a LikeService parameter.</p>
	 * The autowired tag is used so Spring creates a bean wiring to the LikeService class.
	 * 
	 * @param LikeService ls
	 */
	@Autowired
	public void setLs(LikeService ls) {
		this.ls = ls;
	}
	
	/**
	 * <p>The getAll method returns a list of LikeBuilts.</p>
	 * It gets a list of Likes from the database and rebuilds them into a format that can be more easily returned.
	 * 
	 * @return List<LikeBuilt> builtLikes
	 */
	@GetMapping("/likeAll.app")
	public @ResponseBody List<LikeBuilt> getAll(){
		List<Like> likes = ls.getAllLikes();
		List<LikeBuilt> builtLikes = new LinkedList<>();
		for(Like l : likes) {
			builtLikes.add(new LikeBuilt(l));
		}
		return builtLikes;
	}
	
	/**
	 * <p>The getById method returns a LikeBuilt based on a like's ID.</p>
	 * It gets a Like from the database and rebuilds it into a format that can be more easily returned.
	 * 
	 * @param Integer id
	 * @return LikeBuilt builtLike
	 */
	@GetMapping("/likeById.app")
	public @ResponseBody LikeBuilt getById(@RequestParam Integer id) {
		Like like = ls.getLikeById(id);
		LikeBuilt builtLike = new LikeBuilt(like);
		return builtLike;
	}
	
	/**
	 * <p>The getAllLikesByUser method returns a list of LikeBuilts made by a user, using the user's ID.</p>
	 * It gets a list of Likes from the database and rebuilds them into a format that can be more easily returned.
	 * 
	 * @param Integer id
	 * @return List<LikeBuilt> builtLikes
	 */
	@GetMapping("/likeAUser.app")
	public @ResponseBody List<LikeBuilt> getAllLikesByUser(@RequestParam Integer id){
		List<Like> likes = ls.getAllUserLikes(id);
		List<LikeBuilt> builtLikes = new LinkedList<>();
		for(Like l : likes) {
			builtLikes.add(new LikeBuilt(l));
		}
		return builtLikes;
	}
	
	/**
	 * <p>The getAllLikesByPost method returns a list of LikeBuilts on a post, using the post's ID.</p>
	 * It gets a list of Likes from the database and rebuilds them into a format that can be more easily returned.
	 * 
	 * @param Integer id
	 * @return List<LikeBuilt> builtLikes
	 */
	@GetMapping("/likeAPost.app")
	public @ResponseBody List<LikeBuilt> getAllLikesByPost(@RequestParam Integer id){
		List<Like> likes = ls.getAllPostLikes(id);
		List<LikeBuilt> builtLikes = new LinkedList<>();
		for(Like l : likes) {
			builtLikes.add(new LikeBuilt(l));
		}
		return builtLikes;
	}
	
	/**
	 * <p>The getAllLikesByPost method returns a list of LikeBuilts on a comment, using the comment's ID.</p>
	 * It gets a list of Likes from the database and rebuilds them into a format that can be more easily returned.
	 * 
	 * @param Integer id
	 * @return List<LikeBuilt> builtLikes
	 */
	@GetMapping("/likeAComment.app")
	public @ResponseBody List<LikeBuilt> getAllLikesByComment(@RequestParam Integer id){
		List<Like> likes = ls.getAllCommentLikes(id);
		List<LikeBuilt> builtLikes = new LinkedList<>();
		for(Like l : likes) {
			builtLikes.add(new LikeBuilt(l));
		}
		return builtLikes;
	}
	
	/**
	 * <p>The insertLike method inserts a new Like into the database.</p>
	 * 
	 * @param LikeBuilt like
	 */
	@PostMapping("/insertLike.app")
	public void insertLike(@RequestBody LikeBuilt like) {
		Like l = new Like(like);
		
		ls.insertLikeService(l);
	}
	
	/**
	 * <p>The deleteLike method deletes a Like from the database.</p>
	 * 
	 * @param Like like
	 */
	@PostMapping("/deleteLike.app")
	public void deleteLike(@RequestBody LikeBuilt like) {
		Like l = ls.getLikeById(like.getId());		
		ls.deleteLike(l);
	}
	
}
