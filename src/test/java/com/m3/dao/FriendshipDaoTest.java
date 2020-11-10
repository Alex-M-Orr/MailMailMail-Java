//package com.m3.dao;
//
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertTrue;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.when;
//
//import java.util.List;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import com.m3.model.Friendship;
//
//public class FriendshipDaoTest {
//
//	private FriendshipDao fd;
//	private FriendshipDao mockFD;
//	
//	@Before
//	public void setup() {
//		fd = new FriendshipDao();
//		mockFD = mock(FriendshipDao.class);
//	}
//	
//	@Test
//	public void findAllTest() {
//		List<Friendship> friendships = fd.findAll();
//		assertTrue(friendships.size() > 0);
//	}
//	
//	@Test
//	public void findSenderIdTest() {
//		Friendship f = fd.findById(1);
//		assertNotNull(f);
//	}
//	
//	@Test
//	public void findReceiverIdTest() {
//		Friendship f = fd.findById(2);
//		assertNotNull(f);
//	}
//	
//	@Test
//	public void updateTest() {
//		Friendship f = new Friendship();
//		when(mockFD.update(f)).thenReturn(f);
//		f = mockFD.update(f);
//		assertNotNull(f);
//	}
//	
//	@Test
//	public void saveTest() {
//		Friendship f = new Friendship();
//		when(mockFD.save(f)).thenReturn(f);
//		f = mockFD.save(f);
//		assertNotNull(f);
//	}
//	
//}
