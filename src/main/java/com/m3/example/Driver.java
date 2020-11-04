package com.m3.example;

import java.time.LocalDateTime;

import com.m3.dao.UserDao;
import com.m3.model.User;

public class Driver {
	public static void main(String[] args) {
		LocalDateTime lt = LocalDateTime.now();
		UserDao ud = new UserDao();
		User u1 = new User(0, "robert3", "asdfpass", "ghjJay", "ghjgSchwin", lt, "ghjgasdfasdfasdfasdf");
		User u2 = new User(0, "John3", "asdfspass", "hfghjghjJasdf", "ghjghasdfas", lt, "ghjghasdfasdfasdfasdf");
//		ud.save(u1);
//		ud.save(u2);

		System.out.println(u1);
		System.out.println(u1.getFirstName());

	}

}
