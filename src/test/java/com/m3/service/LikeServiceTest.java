package com.m3.service;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m3.dao.CommentDao;
import com.m3.dao.PostDao;
import com.m3.dao.UserDao;
import com.m3.model.Comment;
import com.m3.model.Like;
import com.m3.model.Post;
import com.m3.model.User;

public class LikeServiceTest {
	
	private static LikeService ls;
	private static PostDao pd;
	private static CommentDao cd;
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
		pd = ac.getBean(PostDao.class);
		pd.save(p);
		Comment c = new Comment(0, "This is a comment", p, u, LocalDateTime.now());
		cd = ac.getBean(CommentDao.class);
		cd.save(c);
		Like l = new Like(0, p, c, u, LocalDateTime.now());
		ls = ac.getBean(LikeService.class);
		ls.insertLikeService(l);
	}
	
	@Test
	public void getAllLikesTest() {
		assertNotNull(ls.getAllLikes());
	}
	
	@Test
	public void getLikeByIdTest() {
		assertNotNull(ls.getLikeById(1));
	}
	
	@Test
	public void getAllUserLikesTest() {
		assertNotNull(ls.getAllUserLikes(1));
	}
	
	@Test
	public void getAllPostLikesTest() {
		assertNotNull(ls.getAllPostLikes(1));
	}
	
	@Test
	public void getAllCommentLikesTest() {
		assertNotNull(ls.getAllCommentLikes(1));
	}
	
	@Test
	public void insertLikeServiceTest() {
		Like l = new Like(null, null, null, LocalDateTime.now());
		assertNotNull(ls.insertLikeService(l));
	}
	
	@Test
	public void deleteLikeTest() {
		Like l = new Like(null, null, null, LocalDateTime.now());
		Like l2 = ls.insertLikeService(l);
		assertNotNull(ls.deleteLike(l2));
	}
	
	@Test
	public void deleteLikeServiceTest() {
		Like l = new Like(null, null, null, LocalDateTime.now());
		Like l2 = ls.insertLikeService(l);
		assertNotNull(ls.deleteLikeService(l2.getId()));
	}
}
