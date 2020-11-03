package com.m3.example;

import java.time.LocalDateTime;

import com.m3.dao.UserDao;
import com.m3.model.User;

public class Driver {
	public static void main(String[] args) {
		LocalDateTime lt = LocalDateTime.now();
		UserDao ud = new UserDao();
		User u1 = new User(0, "jey123", "pass", "Jay", "Schwin", lt, "asdfasdfasdfasdf");
		User u2 = new User(0, "2343", "pass", "Jasdf", "asdfas", lt, "asdfasdfasdfasdf");
		ud.save(u1);
		ud.save(u2);

		System.out.println(ud.findAll());

	}

}
