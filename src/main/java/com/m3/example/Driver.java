package com.m3.example;

import java.time.LocalDateTime;

<<<<<<< HEAD
import com.m3.dao.CommentDao;
import com.m3.dao.LikeDao;
import com.m3.dao.PostDao;
import com.m3.dao.UserDao;
import com.m3.model.Comment;
import com.m3.model.Like;
import com.m3.model.Post;
=======
import com.m3.dao.FriendshipDao;
import com.m3.dao.UserDao;
import com.m3.model.Friendship;
>>>>>>> 94bd07dea791de20bd49f497f14e88d2bcb06f53
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
<<<<<<< HEAD
		
		
		System.out.println(ud.findAll());
		/******************Post Setup********************/
		PostDao pd = new PostDao();
		Post p1 = new Post(0, "I love M3! The best up and comming Revature social media platform.", null, u1, lt);
		
		pd.save(p1);
		System.out.println(pd.findAll());
		
		/******************Like Setup********************/
		LikeDao ld = new LikeDao();
		Like l1 =  new Like(p1, null, u2, lt);
		Like l2 =  new Like(p1, null, u3, lt);
		
		ld.save(l1);
		ld.save(l2);
		
		System.out.println(ld.findAll());
		/******************Comment Setup*************************/
		CommentDao cd = new CommentDao();
		Comment c1 = new Comment("Well put! I could not agree more!", p1, u3, lt);
		Comment c2 = new Comment("I can't believe it only took 5 associates built this!", p1, u2, lt);
		
		cd.save(c1);
		cd.save(c2);
		
		System.out.println(cd.findAll());
	}
=======

		User u4 = new User(0, "jordan.d.hunnicutt@gmail.com", "dummyJordan2", "Jordan", "Hunnicutt", lt, "photo path",
				null, null, null);
		Friendship f1 = new Friendship();
		f1.setSender(u4);
		f1.setreceiver(ud.findById(3));
		f1.setAccepted(true);
>>>>>>> 94bd07dea791de20bd49f497f14e88d2bcb06f53

		ud.save(u4);
		fd.save(f1);

		System.out.println(ud.findAll());
		System.out.println(fd.findAll());
	}
}
