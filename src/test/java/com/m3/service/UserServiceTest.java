package com.m3.service;

import static org.junit.Assert.assertNotNull;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m3.model.User;

public class UserServiceTest {

	private static UserService us;

	@BeforeClass
	public static void setup() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("configtest.xml");
		User u = new User();
		u.setId(1);
		u.setEmail("userServiceTest@mail.com");
		u.setPassword("testPass");
		u.setFirstName("testF");
		u.setLastName("testL");
		// u.setDateJoined(LocalDateTime.now());
		us = ac.getBean(UserService.class);
		us.save(u);
	}

	@Test
	public void findAllUsersTest() {
		assertNotNull(us.findAll());
	}

	@Test
	public void findByIdTest() {
		assertNotNull(us.findById(1));
	}

	@Test
	public void findByEmailTest() {
		assertNotNull(us.findByEmail("userServiceTest@mail.com"));
	}

	@Test
	public void findByEmailAndPasswordTest() {
		assertNotNull(us.findByEmailAndPassword("userServiceTest@mail.com", "testPass"));
	}

	@Test
	public void updateUserTest() {
		User u = us.findById(1);
		u.setPassword("testUpdatePass");
		assertNotNull(us.update(u));
	}

	@Test
	public void saveUserTest() {
		User u = new User();
		u.setId(2);
		u.setEmail("test2@mail.com");
		u.setPassword("test2Pass");
		u.setFirstName("test2F");
		u.setLastName("test2L");
		// u.setDateJoined(LocalDateTime.now());
		assertNotNull(us.save(u));
	}

}
