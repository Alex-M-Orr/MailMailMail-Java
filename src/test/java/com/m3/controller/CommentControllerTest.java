package com.m3.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.m3.model.Comment;
import com.m3.model.CommentBuilt;
import com.m3.model.Post;
import com.m3.model.User;
import com.m3.service.CommentService;

@RunWith(MockitoJUnitRunner.class)
public class CommentControllerTest {

	private static LocalDateTime date;
	Comment testComment;
	User testUser;
	Post testPost;

	@InjectMocks
	private CommentController cc;

	@Mock
	private CommentService cs;

	@Before
	public void setup() {
		date = LocalDateTime.now();

		testUser = new User(0, "test1@email.com", "test1", "tesfname1", "testlname1", null, null, null, null);
		testPost = new Post(0, "testContent", "testPhoto", null, date);
		testComment = new Comment(1, "Testcontent", testPost, testUser, date);
	}

	@Test
	public void getAllTest() {
		assertNotNull(cc.getAll());
	}

	@Test
	public void getByIdTest() {
		Mockito.when(cs.getById(1)).thenReturn(testComment);
		assertNotNull(cc.getById(1));

	}

	@Test
	public void getAllCommentsByPostTest() {
		List<Comment> testList = new ArrayList<>();
		testList.add(testComment);
		Mockito.when(cs.getAllPostComments(1)).thenReturn(testList);
		assertNotNull(cc.getAllCommentsByPost(1));

	}

	@Test
	public void insertCommentTest() {
		cc.insertComment(testComment);
		assertEquals(cc.getAll().size(), 0);

	}

	@Test
	public void getAllCommentsByUserTest() {
		List<Comment> testList = new ArrayList<>();
		testList.add(testComment);
		Mockito.when(cs.getAllUserComments(1)).thenReturn(testList);
		assertNotNull(cc.getAllCommentsByUser(1));

	}

	@GetMapping("/commentAUser.app")
	public @ResponseBody List<CommentBuilt> getAllCommentsByUser(@RequestParam Integer id) {
		List<Comment> comments = cs.getAllUserComments(id);
		List<CommentBuilt> builtComments = new LinkedList<>();
		for (Comment c : comments) {
			builtComments.add(new CommentBuilt(c));
		}
		return builtComments;
	}

	@Test
	public void updateCommentTest() {
		Mockito.when(cs.getById(testComment.getId())).thenReturn(testComment);
		cc.updateComment(testComment);
		assertEquals(cc.getAll().size(), 0);

	}

}
