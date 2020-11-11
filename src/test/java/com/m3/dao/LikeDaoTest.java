package com.m3.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m3.model.Comment;
import com.m3.model.Like;
import com.m3.model.Post;
import com.m3.model.User;

@Transactional
public class LikeDaoTest {

	private static LikeDao ld;
	private static UserDao ud;
	private static PostDao pd;
	private static CommentDao cd;
	private static User us;
	private static User us2;
	private static Like l;
	private static Like l2;
	private static List<Like> likes;

	@BeforeClass
	public static void setup() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("configtest.xml");
		us = new User(0, "likeDaoTest@email.com", "test1", "tesfname1", "testlname1", null, null, null, null);
		us2 = new User(0, "likeDaoTest2@email.com", "test1", "tesfname1", "testlname1", null, null, null, null);
		Post p = new Post(0, "string", "string,", us, LocalDateTime.now());
		Comment c = new Comment(0, "content", p, us, LocalDateTime.now());
		l = new Like(0, p, null, us, LocalDateTime.now());
		l2 = new Like(0, p, null, us2, LocalDateTime.now());

		ld = ac.getBean(LikeDao.class);
		ud = ac.getBean(UserDao.class);
		pd = ac.getBean(PostDao.class);
		cd = ac.getBean(CommentDao.class);

		likes = new ArrayList<>();
		likes.add(l);

		ud.save(us);
		ud.save(us2);
		pd.save(p);
		cd.save(c);

		ld.save(l);

	}

	@Test
	public void findAllTest() {
		assertTrue(likes.size() > 0);
	}

	@Test
	public void findByIdTest() {
		assertNotNull(ld.findById(l.getId()));
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

//	@Test
//	public void deleteTest() {
//		Like l = new Like(0, pd.findById(1), null, ud.findById(1), LocalDateTime.now());
//		ld.save(l);
//		int rows = ld.findAll().size();
//		ld.delete(2);
//		int rowsD = ld.findAll().size();
//		assertTrue(rowsD == rows - 1);
//	}
//
//	@Test
//	public void saveTest() {
//		Like l = new Like(0, pd.findById(1), null, ud.findById(1), LocalDateTime.now());
//		assertTrue(ld.save(l) != null);
//	}

	@Test
	public void saveAndDeleteTest() {

		assertNotNull(ld.save(l2));
		int rows = ld.findAll().size();
		ld.delete(l2.getId());
		int rowsD = ld.findAll().size();
		assertTrue(rowsD == rows - 1);
	}

//	@Test
//	public void saveTest() {
//		Like l = new Like(0, pd.findById(1), null, ud.findById(us2.getId()), LocalDateTime.now());
//
//	}

}
