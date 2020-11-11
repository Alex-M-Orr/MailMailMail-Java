package com.m3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.m3.dao.PostDao;
import com.m3.model.Post;

/**
 * 
 * <h1>PostService</h1>
 * <p>The post service is used to pass information about a Post between the controller layer and the repository.</p>
 * <p>This component uses annotations to indicate that it is a service, and that it has connected beans.</p>
 * 
 * @authors Alex Orr, Enoch Cho, Jordan Hunnicutt, Robert Porto, Tyrone Veneracion
 *
 */
@Service
public class PostService {

	/**
	 * This field is a PostDao, which is a component used to communicate directly with the repository.
	 */
	private PostDao pd;

	/**
	 * <p> This no argument constructor creates the PostService.</p>
	 */
	public PostService() {
		super();
	}

	/**
	 * <p> This constructor creates the PostService and gives it an instance of a PostDao.</p>
	 * 
	 * @param PostDao pd
	 */
	public PostService(PostDao pd) {
		super();
		this.pd = pd;
	}

	/**
	 * <p>The getPd method retrieves the PostDao field.</p>
	 * 
	 * @return PostDao pd
	 */
	public PostDao getPd() {
		return pd;
	}

	/**
	 * 
	 * <p>The setPd method sets the PostDao field based on a PostDao parameter.</p>
	 * The autowired tag is used so Spring creates a bean wiring to the PostDao class.
	 * 
	 * @param PostDao pd
	 */
	@Autowired
	public void setPd(PostDao pd) {
		this.pd = pd;
	}

	/**
	 * <p>The getAllPosts method returns a list of Posts.</p>
	 * 
	 * @return List<Post> PostDao.findAll()
	 */
	public List<Post> getAllPosts() {
		return pd.findAll();
	}

	/**
	 * <p>The getAllPostsByUser method returns a list of Posts made by a user, using the user's ID.</p>
	 * 
	 * @param Integer i
	 * @return List<Post> PostDao.findPostsForUser(i)
	 */
	public List<Post> getAllPostsByUser(Integer i){
		return pd.findPostsForUser(i);
	}
	
	/**
	 * <p>The findById method returns a Post based on a post's ID.</p>
	 * 
	 * @param Integer id
	 * @return Post PostDao.findById(id)
	 */
	public Post findById(Integer id) {
		return pd.findById(id);
	}
	
	/**
	 * <p>The updatePost method updates a Post in the database, then returns the updated Post.</p>
	 * 
	 * @param Post p
	 * @return Post PostDao.update(p)
	 */
	public Post updatePost(Post p) {
		return pd.update(p);
	}
	
	/**
	 * <p>The save method inserts a Post into the database, then returns the inserted Post.</p>
	 * 
	 * @param Post p
	 * @return Post PostDao.save(p)
	 */
	public Post save(Post p) {
		return pd.save(p);
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
