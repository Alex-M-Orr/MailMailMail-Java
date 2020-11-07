package com.m3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3.dao.PostDao;
import com.m3.model.Post;

//@Service("postservice")
@Service
public class PostService {

//	@Autowired
	private PostDao pd;

	public PostService() {
		super();
	}

//	@Autowired
	public PostService(PostDao pd) {
		super();
		this.pd = pd;
	}

	public PostDao getPd() {
		return pd;
	}

	@Autowired
	public void setPd(PostDao pd) {
		this.pd = pd;
	}

	public List<Post> getAllPosts() {
		return pd.findAll();
	}

}
