package com.m3.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;

import com.m3.model.Post;

public class PostDaoTest {

	private PostDao pd;
//	private PostDao pdMock;

	@Before
	public void setup() {
//		pdMock = Mockito.mock(PostDao.class);
		pd = new PostDao();

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
	@Transactional
	public void updateTest() {
		Post post = pd.findById(1);
//		post.setContent("I love M3! The best up and comming Revature social media platform.");
		post.setContent("Sorry, change this back");
		String cnt = post.getContent();

		assertEquals(cnt, "Sorry, change this back");
		throw new RuntimeException();

	}

}
