package com.m3.service;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m3.dao.UserDao;
import com.m3.model.Post;
import com.m3.model.User;

public class PostServiceTest {

	private static PostService ps;
	private static UserDao ud;
	
	@BeforeClass
	public static void setup() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("configtest.xml");
		User u = new User();
		u.setId(1);
		u.setEmail("test@mail.com");
		u.setPassword("testPass");
		u.setFirstName("testF");
		u.setLastName("testL");
		u.setDateJoined(LocalDateTime.now());
		ud = ac.getBean(UserDao.class);
		ud.save(u);
		Post p = new Post(0, "This is a post", "This is a photo", u, LocalDateTime.now());
		ps = ac.getBean(PostService.class);
		ps.save(p);
	
	}
	
	@Test
	public void getAllPostsTest() {
		assertNotNull(ps.getAllPosts());
	}
	
	@Test
	public void getAllPostsByUserTest() {
		assertNotNull(ps.getAllPostsByUser(1));
	}
	
	@Test
	public void findPostByIdTest() {
		assertNotNull(ps.findById(1));
	}
	
	@Test
	public void updatePostTest() {
		Post p = ps.findById(1);
		p.setContent("This is changed");
		assertNotNull(ps.updatePost(p));
	}
	
	@Test
	public void savePostTest() {
		Post p = new Post(0, "This is a new post", "This is a new photo", null, LocalDateTime.now());
		assertNotNull(ps.save(p));
	}
	
}
