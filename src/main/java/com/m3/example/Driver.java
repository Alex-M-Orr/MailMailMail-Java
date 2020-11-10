package com.m3.example;

import java.time.LocalDateTime;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.m3.dao.LikeDao;
import com.m3.dao.PostDao;
import com.m3.dao.UserDao;
import com.m3.model.Like;
import com.m3.model.Post;
import com.m3.model.User;

public class Driver {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("config.xml");
		UserDao ud = ac.getBean(UserDao.class);
		PostDao pd = ac.getBean(PostDao.class);
		LikeDao ld = ac.getBean(LikeDao.class);
		LocalDateTime lt = LocalDateTime.now();
//		User u1 = new User(0, "aorr917@gmail.com", "password", "Alex", "Orr", lt, "sdkjfgnskjdfngf", null, null, null);
//		User u2 = new User(0, "robert.porto@revature.net", "robert", "Robert", "Porto", lt, "jdhfxbggsdfgehtfyc", null,
//				null, null);
//		User u3 = new User(0, "jordan.hunnicutt@revature.net", "dummyJordan", "Jordan", "Hunnicut", lt,
//				"sdkjfgnskjduydfbgfngf", null, null, null);

//		ud.save(u1);
//		ud.save(u2);
//		ud.save(u3);

		
		User u = ud.findById(1);
		User u2 = ud.findById(2);
		Post p1 = new Post(0, "I love M3! The best up and comming Revature social media platform.", null, u, lt);
		
		pd.save(p1);
//		
		Like l1 = new Like(0, p1, null, u2, lt);
		
		ld.save(l1);
////		

		System.out.println(ud.findAll());
		
		
	}

}

