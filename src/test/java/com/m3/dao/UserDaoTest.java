package com.m3.dao;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.m3.model.User;

@Transactional
public class UserDaoTest {
	
	private UserDao ud;
	
	@Before
	public void setup() {
		User us = new User(0, "test1@email.com", "test1", "tesfname1", "testlname1", LocalDateTime.now(), null, null, null, null);
		ud = new UserDao();
		ud.save(us);
		
	}
	
	@Test
	public void findAllTest() {
		List<User> users = ud.findAll();
		assertTrue(users.size() > 0);
	}
	
	@Test
	public void saveTest() {
		int rows = ud.findAll().size();
		User u = new User(0, "test@email.com", "test", "tesfname", "testlname", LocalDateTime.now(), null, null, null, null);
		ud.save(u);
		int newrows = ud.findAll().size();
		assertTrue(newrows == rows+1);
	}
}
