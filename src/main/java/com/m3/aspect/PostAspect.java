package com.m3.aspect;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PostAspect {
	
	private static Logger postLogger = LogManager.getLogger(PostAspect.class);

	
	@AfterReturning("execution(* com.m3.dao.PostDao.save(..))")
	public void afterPostCreate(JoinPoint jp) {
		Object[] args =jp.getArgs();
		String msg = "";
		for(Object i: args) {
			msg+=i.toString() + " ";
		}
		System.out.println(msg);
		postLogger.log(Level.getLevel("CREATEPOST"), "Post Created: " + msg);
	}
}
