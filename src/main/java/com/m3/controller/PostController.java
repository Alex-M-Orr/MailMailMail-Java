package com.m3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m3.model.Post;
import com.m3.service.PostService;

@Controller
@CrossOrigin
@RequestMapping("/post.app")
public class PostController {
//	@Autowired
	private PostService ps;

	public PostService getPs() {
		return ps;
	}

	@Autowired
	public void setPs(PostService ps) {
		this.ps = ps;
	}

	@GetMapping
	public @ResponseBody List<Post> getAll() {
		return ps.getAllPosts();
	}

//	@GetMapping
//	public @ResponseBody List<String> getAll() {
//		return ps.getAllPostsString();
//
//	}

}
