package com.m3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m3.dao.CommentDao;
import com.m3.dao.LikeDao;

public class P2DriverWithORM {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		LikeDao ld = ac.getBean(LikeDao.class);
		CommentDao cd = ac.getBean(CommentDao.class);
//		Like l = new Like();
//		l.setDateCreated(LocalDateTime.now());
//		ld.save(l);
		System.out.println(ld.findAll());
		System.out.println(cd.findAll());
	}
	
}
