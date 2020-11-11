package com.m3.service;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m3.dao.PostDao;
import com.m3.dao.UserDao;
import com.m3.model.Comment;
import com.m3.model.Post;
import com.m3.model.User;

public class CommentServiceTest {

	private static CommentService cs;
	private static PostDao pd;
	private static UserDao ud;

	@BeforeClass
	public static void setup() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("configtest.xml");
		User u = new User();
		u.setId(1);
		u.setEmail("commentServiceTest@mail.com");
		u.setPassword("testPass");
		u.setFirstName("testF");
		u.setLastName("testL");
		// u.setDateJoined(LocalDateTime.now());
		ud = ac.getBean(UserDao.class);
		ud.save(u);
		Post p = new Post(0, "This is a post", "This is a photo", u, LocalDateTime.now());
		pd = ac.getBean(PostDao.class);
		pd.save(p);
		Comment c = new Comment(0, "This is a comment", p, u, LocalDateTime.now());
		cs = ac.getBean(CommentService.class);
		cs.insertCommentService(c);
	}

	@Test
	public void getAllCommentsTest() {
		assertNotNull(cs.getAllComments());
	}

	@Test
	public void getCommentByIdTest() {
		assertNotNull(cs.getById(1));
	}

	@Test
	public void getUserCommentsTest() {
		assertNotNull(cs.getAllUserComments(1));
	}

	@Test
	public void getPostCommentsTest() {
		assertNotNull(cs.getAllPostComments(1));
	}

	@Test
	public void insertCommentTest() {
		Comment c = new Comment(0, "This is a different comment", null, null, LocalDateTime.now());
		assertNotNull(cs.insertCommentService(c));
	}

	@Test
	public void updateCommentTest() {
		Comment c = cs.getById(1);
		assertNotNull(cs.updateCommentService(c));
	}

}
