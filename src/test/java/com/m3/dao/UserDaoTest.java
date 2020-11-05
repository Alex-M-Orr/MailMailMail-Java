package com.m3.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import java.time.LocalDateTime;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.m3.model.User;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {
	
	private UserDao ud;
	private UserDao mockUserDao;
	private User u;
	
	@Before
	public void setup() {
		ud = new UserDao();
		mockUserDao = mock(UserDao.class);

	}
	
	@Test
	public void findAllTest() {
		List<User> users = ud.findAll();
		System.out.println(ud.findAll());
		assertTrue(users.size() > 0);
	}
	
	@Test
	public void findByIdTest() {
		User u = ud.findById(1);
		assertTrue(u != null);
	}
	@Test
	public void findByEmailTest() {
		User u = ud.findByEmail("aorr917@gmail.com");
		System.out.println(u.toString());
		assertTrue(u != null);
	}
//	@Test
//	@Transactional(rollbackOn=Exception.class)
//	public void saveTest() throws runTimeException {
//		User u = new User("tester1@email.com", "test", "Alex", "Orr", LocalDateTime.now(), "newphoto");
//		ud.save(u);
//		assertNotNull(u);
//		throw runTimeException;
//	}
	
	
}
