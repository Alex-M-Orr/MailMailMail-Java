//package com.m3.dao;
//
//import java.util.List;
//
//import javax.transaction.Transactional;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.m3.model.Friendship;
//import com.m3.util.HibernateUtil;
//
//@Repository
//@Transactional
//public class FriendshipDao /*implements DaoContract<Friendship, Integer>*/{
//
//	private SessionFactory sessfact;
//	
//	@Autowired
//	public FriendshipDao(SessionFactory sessfact) {
//		this.sessfact = sessfact;
//	}
//	
//	public FriendshipDao() {
//	}
//	
////	@Override
//	public List<Friendship> findAll() {
//		List<Friendship>list = sessfact.openSession().createQuery("from Friendship", Friendship.class).list();
//		return list;
//	}
//
////	@Override
//	public Friendship findById(Integer i) {
//		Friendship f = HibernateUtil.getSessionFactory()
//				.openSession()
//				.createQuery("from Friendship where senderId ="+i, Friendship.class)
//				.list().get(0);
//		Friendship f2 = HibernateUtil.getSessionFactory()
//				.openSession()
//				.createQuery("from Friendship where receiverId ="+i, Friendship.class)
//				.list().get(0);
//		try {
//			boolean b = f.equals(null);
//			return f;
//		} catch(NullPointerException e) {
//			try {
//				boolean b2 = f2.equals(null);
//				return f2;
//			} catch(NullPointerException e2) {
//				
//			}
//		}
//		return null;
//	}
//	
//	
////	@Override
//	public Friendship update(Friendship t) {
//		sessfact.openSession().update(t);
//		return t;
//	}
//
////	@Override
//	public Friendship save(Friendship t) {
//		sessfact.openSession().save(t);
//		return t;
//	}
//
////	@Override
//	public Friendship delete(Integer id1, Integer id2) {
//		Friendship f = findById(id1);
//		//...what?
//		return f;
//	}
//
//}
