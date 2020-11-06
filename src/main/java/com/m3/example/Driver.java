package com.m3.example;

import java.time.LocalDateTime;

import com.m3.dao.FriendshipDao;
import com.m3.dao.UserDao;
import com.m3.model.Friendship;
import com.m3.model.User;

public class Driver {
	public static void main(String[] args) {
		LocalDateTime lt = LocalDateTime.now();
		UserDao ud = new UserDao();
		FriendshipDao fd = new FriendshipDao();
		User u1 = new User(0, "aorr917@gmail.com", "password", "Alex", "Orr", lt, "sdkjfgnskjdfngf", null, null, null);
		User u2 = new User(0, "robert.porto@revature.net", "robert", "Robert", "Porto", lt, "jdhfxbggsdfgehtfyc", null,
				null, null);
		User u3 = new User(0, "jordan.hunnicutt@revature.net", "dummyJordan", "Jordan", "Hunnicut", lt,
				"sdkjfgnskjduydfbgfngf", null, null, null);

		ud.save(u1);
		ud.save(u2);
		ud.save(u3);

		User u4 = new User(0, "jordan.d.hunnicutt@gmail.com", "dummyJordan2", "Jordan", "Hunnicutt", lt, "photo path",
				null, null, null);
		Friendship f1 = new Friendship();
		f1.setSender(u4);
		f1.setreceiver(ud.findById(3));
		f1.setAccepted(true);

		ud.save(u4);
		fd.save(f1);

		System.out.println(ud.findAll());
		System.out.println(fd.findAll());
	}

}

