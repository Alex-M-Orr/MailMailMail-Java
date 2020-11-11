package com.m3.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m3.model.Post;
import com.m3.model.PostBuilt;
import com.m3.service.PostService;
/**
 * 
 * <h1>PostController</h1>
 * <p>The post controller is used to get information about a post from the front end based on different request mappings.</p>
 * <p>This component uses annotations to indicate that it is a controller, that it uses cross origin references, that it has request mappings, and that it has connected beans</p>
 * 
 * @authors Alex Orr, Enoch Cho, Jordan Hunnicutt, Robert Porto, Tyrone Veneracion
 *
 */
@Controller
@CrossOrigin
@RequestMapping
public class PostController {
	/**
	 * This field is a PostService, which is a component used to communicate between this controller and the repository.
	 */
	private PostService ps;

	/**
	 * <p>The getPs method retrieves the PostService field.</p>
	 * 
	 * @return PostService ps
	 */
	public PostService getPs() {
		return ps;
	}

	/**
	 * 
	 * <p>The setPs method sets the PostService field based on a PostService parameter.</p>
	 * The autowired tag is used so Spring creates a bean wiring to the PostService class.
	 * 
	 * @param PostService ps
	 */
	@Autowired
	public void setPs(PostService ps) {
		this.ps = ps;
	}

	/**
	 * <p>The getAll method returns a list of PostBuilts.</p>
	 * It gets a list of Posts from the database and rebuilds them into a format that can be more easily returned.
	 * 
	 * @return List<PostBuilt> builtPosts
	 */
	@GetMapping("/postAll.app")
	public @ResponseBody List<PostBuilt> getAll() {
		List<Post> posts = ps.getAllPosts();
		List<PostBuilt> builtPosts = new LinkedList<>();
		for(Post p : posts) {
			builtPosts.add(new PostBuilt(p));
		}
		
		
		return builtPosts;
	}

	/**
	 * <p>The getAllPostsByUser method returns a list of PostBuilts made by a user, using the user's ID.</p>
	 * It gets a list of Posts from the database and rebuilds them into a format that can be more easily returned.
	 * 
	 * @param Integer id
	 * @return List<PostBuilt> builtPosts
	 */
	@GetMapping("/postAUser.app")
	public @ResponseBody List<PostBuilt> getAllPostsByUser(@RequestParam Integer id) {
		List<Post> posts = ps.getAllPostsByUser(id);
		List<PostBuilt> builtPosts = new LinkedList<>();
		for(Post p : posts) {
			builtPosts.add(new PostBuilt(p));
		}
		
		return builtPosts;
	}
	
	/**
	 * <p>The getById method returns a PostBuilt based on a post's ID.</p>
	 * It gets a Post from the database and rebuilds it into a format that can be more easily returned.
	 * 
	 * @param Integer id
	 * @return PostBuilt pb
	 */
	@GetMapping("/postById.app")
	public @ResponseBody PostBuilt getById(@RequestParam Integer id){
		PostBuilt pb = new PostBuilt(ps.findById(id));
		return pb;
	}
	
	/**
	 * <p>The save method inserts a new Post into the database, and returns a PostBuilt.</p>
	 * The Post is rebuilt into a format that is more easily returned.
	 * 
	 * @param Post p
	 * @return new PostBuilt
	 */
	@PostMapping("/postSave.app")
	public @ResponseBody PostBuilt save(@RequestBody PostBuilt pb ) {
		Post p = new Post(pb);
		ps.save(p);
		return pb;
	}
	
	/**
	 * <p>The update method updates a Post in the database, and returns a PostBuilt.</p>
	 * The Post is rebuilt into a format that is more easily returned.
	 * 
	 * @param Post p
	 * @return PostBuilt pb
	 */
	@PutMapping("/postUpdate.app")
	public @ResponseBody PostBuilt update(@RequestBody PostBuilt p) {
		Post post = ps.findById(p.getId());
		try {
			post.setContent(p.getContent());
		} catch (Exception e) {}
		try {
			post.setPhoto(p.getPhoto());
		}catch (Exception e) {}
		
		ps.updatePost(post);
		return p;
	}

//	@GetMapping
//	public @ResponseBody List<String> getAll() {
//		return ps.getAllPostsString();
//
//	}

}
