package com.m3.aspect;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * 
 * <h1>UserAspect</h1>
 * <p>
 * The UserAspect is used to log specific events that happen around the 
 * Post object and it's DAO methods.
 * </p>
 * <p> 
 * This component uses annotations to indicate that is is an Aspect.
 * </p>
 * 
 * @authors Alex Orr, Enoch Cho, Jordan Hunnicutt, Robert Porto, Tyrone
 *          Veneracion
 *
 */


@Aspect
@Component
public class PostAspect {
	
	/**
	 * This field is an instance of a Log4j Logger, which is used to log information
	 * to the log files.
	 */
	
	private static Logger postLogger = LogManager.getLogger(PostAspect.class);

	
	/**
	 * <p>
	 * Uses the AfterReturning annotation with a pointcut expression to target the PostDao 
	 * save method. This advice will log when a user has successfully created a post to a
	 *  project2-CreatePost-*.log file.
	 * </p>
	 * 
	 * @param JoinPoint
	 * @return void
	 */
	
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
