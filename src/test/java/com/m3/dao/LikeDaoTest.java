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
		
		ld = ac.getBean(LikeDao.class);
		ud = ac.getBean(UserDao.class);
		pd = ac.getBean(PostDao.class);
		cd = ac.getBean(CommentDao.class);
		ud.save(us);
		pd.save(p);
		cd.save(c);
		System.out.println("Made it up to like");
		ld.save(l);
		System.out.println("Made it through setup");
	}
	
	@Test
	public void findAllTest() {
		List<Like> likes = ld.findAll();
		assertTrue(likes.size() > 0);
	}
	
}
