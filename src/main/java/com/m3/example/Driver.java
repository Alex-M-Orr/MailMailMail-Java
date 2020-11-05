package com.m3.example;

import java.time.LocalDateTime;

import com.m3.dao.UserDao;
import com.m3.model.User;

public class Driver {
	public static void main(String[] args) {
		LocalDateTime lt = LocalDateTime.now();
		UserDao ud = new UserDao();
<<<<<<< HEAD
//		User u1 = new User(0, "robert3", "asdfpass", "ghjJay", "ghjgSchwin", lt, "ghjgasdfasdfasdfasdf");
//		User u2 = new User(0, "John3", "asdfspass", "hfghjghjJasdf", "ghjghasdfas", lt, "ghjghasdfasdfasdfasdf");
//		ud.save(u1);
//		ud.save(u2);

//		System.out.println(u1);
//		System.out.println(u1.getFirstName());
=======
		User u1 = new User(0, "aorr917@gmail.com", "password", "Alex", "Orr", lt, "sdkjfgnskjdfngf", null, null, null);
		User u2 = new User(0, "robert.porto@revature.net", "robert", "Robert", "Porto", lt, "jdhfxbggsdfgehtfyc", null, null, null);
		User u3 = new User(0, "jordan.hunnicutt@revature.net", "dummyJordan", "Jordan", "Hunnicut", lt, "sdkjfgnskjduydfbgfngf", null, null, null);
		
		ud.save(u1);
		ud.save(u2);
		ud.save(u3);
		
		System.out.println(ud.findAll());
		
		
>>>>>>> 536963bc780cf08cbf18da37b80c95befe9c622d

	}

}
