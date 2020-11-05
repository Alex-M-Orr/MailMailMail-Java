package com.m3.dao;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.m3.model.User;

public class UserDaoTest {
	
	private UserDao ud;
	
	@Before
	public void setup() {
		ud = new UserDao();
	}
	
	@Test
	public void findAllTest() {
		List<User> users = ud.findAll();
		assertTrue(users.size() > 0);
	}
	
}
