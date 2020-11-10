package com.m3.dao;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m3.model.Comment;
import com.m3.model.Like;
import com.m3.model.Post;
import com.m3.model.User;

@Transactional
public class LikeDaoTest {

	private LikeDao ld;
	private UserDao ud;
	private PostDao pd;
	private CommentDao cd;
	
	@Before
	public void setup() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("configtest.xml");
		User us = new User(0, "test1@email.com", "test1", "tesfname1", "testlname1", LocalDateTime.now(), null, null, null, null);
		Post p = new Post(0, "string", "string,", us, LocalDateTime.now());
		Comment c = new Comment(0, "content", p, us, LocalDateTime.now());
		Like l = new Like(0, p, null, us, LocalDateTime.now());
		System.out.println("after object creations");
		ld = ac.getBean(LikeDao.class);
		ud = ac.getBean(UserDao.class);
		pd = ac.getBean(PostDao.class);
		cd = ac.getBean(CommentDao.class);

		ud.save(us);
		pd.save(p);
		cd.save(c);

		ld.save(l);
		System.out.println("after bean creations");

	}
	
	@Test
	public void findAllTest() {
		List<Like> likes = ld.findAll();
		assertTrue(likes.size() > 0);
	}
	
	@Test
	public void findByIdTest() {
		assertTrue(ld.findById(1) != null);
	}
	
	@Test
	public void findLikesForUser() {
		assertTrue(ld.findLikesForUser(1) != null);
	}
	
	@Test
	public void findLikesForPost() {
		assertTrue(ld.findLikesForPost(1) != null);
	}
	@Test
	public void findLikesForCommentTest() {
		assertTrue(ld.findLikesForComment(1) != null);
	}
	@Test
	public void deleteTest() {
		Like l = new Like(0, pd.findById(1), null, ud.findById(1), LocalDateTime.now());
		ld.save(l);
		int rows = ld.findAll().size();
		ld.delete(2);
		int rowsD = ld.findAll().size();
		assertTrue(rowsD == rows-1);
	}
	@Test
	public void saveTest() {
		Like l = new Like(0, pd.findById(1), null, ud.findById(1), LocalDateTime.now());
		assertTrue(ld.save(l) != null);
	}
	
}
