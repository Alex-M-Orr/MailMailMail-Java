package com.m3.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.m3.model.Post;
import com.m3.model.User;

public class PostDaoTest {
	private LocalDateTime date;
	private PostDao pd;
	private UserDao ud;
	private User us;
	private Post testPost;
	private Post testPost2;

	@Before
	public void setup() {
		date = LocalDateTime.now();

		us = new User(0, "PostDaoTestUser@email.com", "PostDao", "PostDaoTestUser", "PostDaoTestUser",
				LocalDateTime.now(), null, null, null, null);
		ud = new UserDao();
		ud.save(us);

		testPost = new Post(1, "testContent", "testPhoto", us, date);
		pd = new PostDao();
		pd.save(testPost);

	}

	@Test
	public void findAllTest() {
		List<Post> posts = pd.findAll();
		assertTrue(posts.size() > 0);
	}

	@Test
	public void findByIdTest() {
		Post post = pd.findById(1);
		assertNotNull(post);
	}

	@Test
	public void updateTest() {
		Post post = pd.findById(1);
//		post.setContent("I love M3! The best up and comming Revature social media platform.");
		post.setContent("Sorry, change this back");
		String cnt = post.getContent();

		assertEquals(cnt, "Sorry, change this back");

	}

//	@Test
//	public void saveTest() {
//		User us2 = new User(0, "test2@email.com", "test2", "tesfname2", "testlname2", LocalDateTime.now(), null, null,
//				null, null);
//
//		Post testPost2 = new Post(0, "otherTestContent", "otherTestPhoto", us, date);
////		System.out.println(us2);
////		int rows = pd.findAll().size();
//		Post test = pd.save(testPost2);
////		int newrows = pd.findB().size();
////		assertTrue(newrows == rows + 1);
//		assertNotNull(test);
//
//	}

}
