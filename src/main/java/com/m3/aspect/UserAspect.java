package com.m3.aspect;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class UserAspect {

	private static Logger userLogger = LogManager.getLogger(UserAspect.class);
	
	@AfterReturning("execution(* com.m3.dao.UserDao.findByEmailAndPassword(..))")
	public void afterSuccessfulLogin(JoinPoint jp) {
		Object[] args = jp.getArgs();
		userLogger.log(Level.getLevel("LOGIN"), "User login: " + args[0].toString());

	}
	@AfterThrowing("execution(* com.m3.dao.UserDao.findByEmailAndPassword(..))")
	public void afterUnsuccessfulLogin(JoinPoint jp) {
		Object[] args =jp.getArgs();
		userLogger.log(Level.getLevel("LOGIN"), "Unsuccessful login attempt on user:" + args[0].toString());
	}
	@AfterReturning("execution(* com.m3.dao.UserDao.save(..))")
	public void afterRegister(JoinPoint jp) {
		Object[] args =jp.getArgs();
		String msg = "";
		for(Object i: args) {
			msg+=i.toString() + " ";
		}
		System.out.println(msg);
		userLogger.log(Level.getLevel("REGISTER"), "User Registered: " + msg);
	}
	@AfterReturning("execution(* com.m3.dao.UserDao.update(..))")
	public void afterUserUpdate(JoinPoint jp) {
		Object[] args =jp.getArgs();
		String msg = "";
		for(Object i: args) {
			msg+=i.toString() + " ";
		}
		System.out.println(msg);
		userLogger.log(Level.getLevel("ACCUPDATE"), "User Registered: " + msg);
	}
}
