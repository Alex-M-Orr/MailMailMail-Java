package com.m3.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.m3.model.Comment;
import com.m3.model.Like;
import com.m3.model.Post;
import com.m3.model.User;
import com.m3.model.UserBuilt;
import com.m3.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	private static LocalDateTime date;
	User testUser;
	User testUser2;
	Post testPost;
	Like testLike;
	Like testLike2;
	Comment testComment;

	@InjectMocks
	private UserController uc;

	@Mock
	private UserService us;

	@Before
	public void setup() {
		testUser = new User(0, "test1@email.com", "test1", "tesfname1", "testlname1", null, null, null, null);
	}

	@Test
	public void getAllTest() {
		assertNotNull(uc.getAll());
	}

	@Test
	public void getUserTest() {
		Mockito.when(us.findById(1)).thenReturn(testUser);
		assertNotNull(uc.getUser(1));
	}

	@Test
	public void getUserByEmailTest() {
		Mockito.when(us.findByEmail("test1@email.com")).thenReturn(testUser);
		assertNotNull(uc.getUserByEmail("test1@email.com"));
	}

	@Test
	public void createUserTest() {
		uc.createUser(testUser);
		assertEquals(uc.getAll().size(), 0);

	}

	@Test
	public void updateUserTest() {
		Mockito.when(us.findById(testUser.getId())).thenReturn(testUser);
		uc.updateUser(testUser);
		assertEquals(uc.getAll().size(), 0);
	}

	@Test
	public void loginUserTest() {
		Mockito.when(us.findByEmailAndPassword("email", "password")).thenReturn(testUser);
		assertNotNull(uc.loginUser("email", "password"));
	}

}
