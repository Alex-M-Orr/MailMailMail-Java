package com.m3.controller;

import static org.junit.Assert.assertEquals;
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
import com.m3.service.LikeService;

@RunWith(MockitoJUnitRunner.class)
public class LikeControllerTest {
	private static LocalDateTime date;
	User testUser;
	User testUser2;
	Post testPost;
	Like testLike;
	Like testLike2;
	Comment testComment;

	@InjectMocks
	private LikeController lc;

	@Mock
	private LikeService ls;

	@Before
	public void setup() {
		date = LocalDateTime.now();
		testUser = new User(0, "test1@email.com", "test1", "tesfname1", "testlname1", null, null, null, null);
		testUser2 = new User(0, "test2@email.com", "test2", "tesfname2", "testlname2", null, null, null, null);
		testPost = new Post(0, "testContent", "testPhoto", null, date);
		testComment = new Comment(1, "Testcontent", testPost, testUser, date);
		testLike = new Like(0, testPost, null, testUser, date);
		testLike2 = new Like(0, null, testComment, testUser, date);
	}

	@Test
	public void getAllTest() {
		assertNotNull(lc.getAll());
	}

	@Test
	public void getByIdTest() {
		Mockito.when(ls.getLikeById(1)).thenReturn(testLike);
		assertNotNull(lc.getById(1));

	}

	@Test
	public void getAllLikesByUserTest() {
		List<Like> testList = new ArrayList<>();
		testList.add(testLike);
		Mockito.when(ls.getAllUserLikes(1)).thenReturn(testList);
		assertNotNull(lc.getAllLikesByUser(1));

	}

	@Test
	public void getAllLikesByPostTest() {
		List<Like> testList = new ArrayList<>();
		testList.add(testLike);
		Mockito.when(ls.getAllPostLikes(1)).thenReturn(testList);
		assertNotNull(lc.getAllLikesByPost(1));

	}

	@Test
	public void getAllLikesByCommentTest() {
		List<Like> testList = new ArrayList<>();
		testList.add(testLike);
		Mockito.when(ls.getAllCommentLikes(1)).thenReturn(testList);
		assertNotNull(lc.getAllLikesByComment(1));

	}

	@Test
	public void insertLikeTest() {
		lc.insertLike(testLike);
		assertEquals(lc.getAll().size(), 0);
	}

//	@Test
//	public void updateLikeTest() {
//		Mockito.when(ls.getLikeById(testLike.getId())).thenReturn(testLike);
//		lc.updateLike(testLike);
//		assertEquals(lc.getAll().size(), 0);
//	}

}
