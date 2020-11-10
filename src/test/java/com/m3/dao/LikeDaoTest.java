package com.m3.dao;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m3.model.Like;
import com.m3.model.Post;
import com.m3.model.User;

@Transactional
public class LikeDaoTest {

	private static UserDao ud;
	private static PostDao pd;
	private static LikeDao ld;
	
	@BeforeClass
	public void setup() {
		System.out.println("before setup");
		LocalDateTime rn = LocalDateTime.now();
		ApplicationContext ac = new ClassPathXmlApplicationContext("configtest.xml");
		ud = ac.getBean(UserDao.class);
		pd = ac.getBean(PostDao.class);
		ld = ac.getBean(LikeDao.class);
		
		User u = new User(1, "test1@email.com", "test1", "tesfname1", "testlname1", rn, null, null,
				null, null);
		ud.save(u);
		
		Post p = new Post(1, "testContent", "testPhoto", u, rn);
		pd.save(p);
		
		Like l = new Like(0, p, null, u, rn);
		ld.save(l);
	}
	
	@Test
	public void findAllTest() {
		List<Like> likes = ld.findAll();
		assertTrue(likes.size()>0);
	}
	
}
