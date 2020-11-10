package com.m3;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m3.dao.CommentDao;
import com.m3.dao.LikeDao;
import com.m3.dao.PostDao;
import com.m3.dao.UserDao;
import com.m3.model.Comment;
import com.m3.model.Like;
import com.m3.model.Post;
import com.m3.model.User;

public class P2DriverWithORM {

	public static void main(String[] args) {
//		LocalDateTime date = LocalDateTime.now();
//
//		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
//		LikeDao ld = ac.getBean(LikeDao.class);
//		CommentDao cd = ac.getBean(CommentDao.class);
//		UserDao ud = ac.getBean(UserDao.class);
//		PostDao pd = ac.getBean(PostDao.class);
////		User testUser = new User(0, "test1@email.com", "test1", "tesfname1", "testlname1", date, null, null, null,
////				null);
//		Post testPost = new Post(0, "testContent", "testPhoto", null, date);
//		Comment testComment = new Comment(1, "delete-me", testPost, testUser, date);
//
////		PostService ps = ac.getBean(PostService.class);
//		// User u = new User(0, "eszrdxgfadsggjkhlhkjfhdgshgdghghkjfhhfcgh",
//		// "jlisdfngkj", "sljhdfnbg", "jhlsgnnf", LocalDateTime.now(), "ishfdgbn", null,
//		// null, null);
//		// ud.save(u);
//		User u = ud.findById(3);
//		Like l = new Like(0, null, null, u, LocalDateTime.now());
//
////		System.out.println(l.getAuthor());
//		System.out.println(testComment);
//		cd.save(testComment);
////		ld.save(l);
//
//		// System.out.println(ld.findAll());
//		// System.out.println(cd.findAll());
////		System.out.println(ud.findAll());
////		System.out.println(ld.findAll());
////		System.out.println(pd.findAll());
////		System.out.println(pd.findPostsForUser(1));

	}

}
