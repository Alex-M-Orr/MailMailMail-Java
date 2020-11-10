package com.m3.dao;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.m3.model.User;

@Transactional
public class UserDaoTest {
	
	private static UserDao ud;
	
	@BeforeClass
	public static void setup() {		
		ApplicationContext ac = new ClassPathXmlApplicationContext("configtest.xml");
		User us = new User(0, "test1@email.com", "test1", "tesfname1", "testlname1", null, null, null, null);
		ud = ac.getBean(UserDao.class);
		ud.save(us);		
	}
	
	@Test
	public void findAllTest() {
		List<User> users = ud.findAll();
		System.out.println(users);
		assertTrue(users.size() > 0);
	}
	
	@Test
	public void saveTest() {
		int rows = ud.findAll().size();
		User u = new User(0, "test@email.com", "test", "tesfname", "testlname", null, null, null, null);
		ud.save(u);
		int newrows = ud.findAll().size();
		assertTrue(newrows == rows+1);
	}
	@Test
	public void findByEmailTest() {
		assertTrue(ud.findByEmail("test1@email.com") !=null);
	}
	@Test
	public void findByIdTest() {
		assertTrue(ud.findById(1) != null);
	}
	@Test
	public void updateTest() {
		User u = ud.findById(1);
		u.setEmail("updatedEmail@email.com");
		ud.update(u);
		assertTrue(ud.findByEmail("updatedEmail@email.com") != null);
	}
	@Test
	public void findByEmailAndPasswordTest() {
		assertTrue(ud.findByEmailAndPassword("test1@email.com", "test1")!=null);
	}
}
