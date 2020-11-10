package com.m3.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m3.model.Post;
import com.m3.model.User;

public class PostDaoTest {
	private static LocalDateTime date;
	private static PostDao pd;
	private static UserDao ud;
	private User us;
	private static Post testPost;
	private Post testPost2;

	@BeforeClass
	public static void setup() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("configtest.xml");
		User us = new User(0, "test1@email.com", "test1", "tesfname1", "testlname1", LocalDateTime.now(), null, null,
				null, null);
		ud = ac.getBean(UserDao.class);
		ud.save(us);

		date = LocalDateTime.now();

		testPost = new Post(1, "testContent", "testPhoto", us, date);
		pd = ac.getBean(PostDao.class);
		pd.save(testPost);

		User us2 = new User(0, "test2@email.com", "test2", "tesfname2", "testlname2", LocalDateTime.now(), null, null,
				null, null);

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
		post.setContent("Sorry, change this back");
		String cnt = post.getContent();
		assertEquals(cnt, "Sorry, change this back");
	}

	@Test
	public void saveTest() {
		Post testPost2 = new Post(0, "otherTestContent", "otherTestPhoto", us, date);
		Post test = pd.save(testPost2);
		assertNotNull(test);
	}
	@Test
	public void findPostsForUserTest() {
		assertTrue(pd.findPostsForUser(1) != null);
	}
	
	
	

}
