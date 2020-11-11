package com.m3.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m3.model.Comment;
import com.m3.model.Post;
import com.m3.model.User;

public class CommentDaoTest {
	private static LocalDateTime date;
	private static PostDao pd;
	private static UserDao ud;
	private static CommentDao cd;
	private User us;
	private static Post testPost;
	private Post testPost2;
	private static Comment comm;
	private static Comment comm2;
	private static Comment comm3;
	private static List<Comment> comments;

	@BeforeClass
	public static void setup() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("configtest.xml");
		User us = new User(0, "commentDaoTest1@email.com", "test1", "tesfname1", "testlname1", null, null, null, null);
		Post p = new Post(0, "string", "string,", us, LocalDateTime.now());
		ud = ac.getBean(UserDao.class);
		ud.save(us);

		testPost = new Post(1, "testContent", "testPhoto", us, LocalDateTime.now());
		pd = ac.getBean(PostDao.class);
		pd.save(testPost);

		comments = new ArrayList<>();
		comm = new Comment(0, "content", testPost, us, LocalDateTime.now());
		comm2 = new Comment(0, "content2", testPost, us, LocalDateTime.now());
		comm3 = new Comment(0, "content3", testPost, us, LocalDateTime.now());
		comments.add(comm);

		cd = ac.getBean(CommentDao.class);
		cd.save(comm);
		cd.save(comm2);

//		User us2 = new User(0, "postDaoTest2@email.com", "test2", "tesfname2", "testlname2", null, null, null, null);

	}

	@Test
	public void findAllTest() {
		assertNotNull(cd.findAll());
	}

	@Test
	public void findByIdTest() {
		assertNotNull(cd.findById(comm.getId()));
	}

	@Test
	public void findCommentsForUserTest() {
		assertNotNull(cd.findCommentsForUser(1));
	}

	@Test
	public void findCommentsForPostTest() {
		assertNotNull(cd.findCommentsForPost(1));
	}

	@Test
	public void updateTest() {
		Comment testComm = cd.findById(comm2.getId());
		testComm.setContent("dootdoot");
		cd.update(testComm);
		assertEquals(testComm.getContent(), "dootdoot");
	}

	@Test
	public void saveAndDeleteTest() {
		assertNotNull(cd.save(comm3));
		int rows = cd.findAll().size();
		cd.delete(comm3.getId());
		int rowsD = cd.findAll().size();
		assertTrue(rowsD == rows - 1);
	}

}
