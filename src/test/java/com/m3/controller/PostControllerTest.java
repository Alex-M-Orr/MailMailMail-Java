package com.m3.controller;

import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
import com.m3.service.PostService;

@RunWith(MockitoJUnitRunner.class)
public class PostControllerTest {
	private static LocalDateTime date;
	User testUser;
	User testUser2;
	Post testPost;
	Like testLike;
	Like testLike2;
	Comment testComment;

	@InjectMocks
	private PostController pc;

	@Mock
	private PostService ps;

	@Before
	public void setup() {
		testUser = new User(0, "test1@email.com", "test1", "tesfname1", "testlname1", null, null, null, null);
		testPost = new Post(1, "testContent", "testPhoto", testUser, date);
	}

	@Test
	public void getAllTest() {
		assertNotNull(pc.getAll());
	}

	@Test
	public void getAllPostsByUserTest() {
		List<Post> testList = new ArrayList<>();
		testList.add(testPost);
		Mockito.when(ps.getAllPostsByUser(1)).thenReturn(testList);
		assertNotNull(pc.getAllPostsByUser(1));
	}

	@Test
	public void getByIdTest() {
		Mockito.when(ps.findById(1)).thenReturn(testPost);
		assertNotNull(pc.getById(1));

	}

	@Test
	public void saveTest() {
		Mockito.when(ps.save(testPost)).thenReturn(testPost);
		assertNotNull(pc.save(testPost));

	}
}
