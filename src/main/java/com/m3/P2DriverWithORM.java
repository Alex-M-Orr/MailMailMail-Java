package com.m3;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m3.dao.CommentDao;
import com.m3.dao.LikeDao;
import com.m3.dao.UserDao;
import com.m3.model.Like;
import com.m3.model.User;

public class P2DriverWithORM {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		LikeDao ld = ac.getBean(LikeDao.class);
		//CommentDao cd = ac.getBean(CommentDao.class);
		UserDao ud = ac.getBean(UserDao.class);
		
		//User u = new User(0, "eszrdxgfadsggjkhlhkjfhdgshgdghghkjfhhfcgh", "jlisdfngkj", "sljhdfnbg", "jhlsgnnf", LocalDateTime.now(), "ishfdgbn", null, null, null);
		//ud.save(u);
		User u = ud.findById(3);
		Like l = new Like(0, null, null, u, LocalDateTime.now());
		
		System.out.println(l.getAuthor());
		
		ld.save(l);
		
		//System.out.println(ld.findAll());
		//System.out.println(cd.findAll());
		System.out.println(ud.findAll());
		System.out.println(ld.findAll());
	}
	
}
