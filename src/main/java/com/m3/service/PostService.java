package com.m3.service;

import java.util.ArrayList;
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

	public List<Post> getAllPostsByUser(Integer i){
		return pd.findPostsForUser(i);
	}
	
//	public List<String> getAllPostsString() {
//		List<String> posts = new ArrayList();
//		for (Post p : pd.findAll()) {
//			String postStr = p.toString();
//			posts.add(postStr);
//		}
//
//		return posts;
//	}

//	public List<Post> getAllPostsString() {
//		List<Post> posts = new ArrayList();
//		for (Post p : pd.findAll()) {
//			String postStr = p.toString();
//			Post newP = null;
//			try {
//				newP = new ObjectMapper().readValue(postStr, Post.class);
//			} catch (JsonMappingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (JsonProcessingException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//			posts.add(newP);
//		}
//
//		return posts;
//	}

}
