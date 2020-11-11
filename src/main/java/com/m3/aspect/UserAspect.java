package com.m3.aspect;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


/**
 * 
 * <h1>UserAspect</h1>
 * <p>
 * The UserAspect is used to log specific events that happen around the 
 * User object and it's DAO methods.
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
public class UserAspect {

	/**
	 * This field is an instance of a Log4j Logger, which is used to log information
	 * to the log files.
	 */
	
	private static Logger userLogger = LogManager.getLogger(UserAspect.class);
	

	
	/**
	 * <p>
	 * Uses the AfterReturning annotation with a pointcut expression to target the UserDao 
	 * findByEmailAndPassword method. This advice will log when a user has successfully logged
	 * into their account to a project2-Login-*.log file.
	 * </p>
	 * 
	 * @param JoinPoint
	 * @return void
	 */
	@AfterReturning("execution(* com.m3.dao.UserDao.findByEmailAndPassword(..))")
	public void afterSuccessfulLogin(JoinPoint jp) {
		Object[] args = jp.getArgs();
		userLogger.log(Level.getLevel("LOGIN"), "User login: " + args[0].toString());

	}
	/**
	 * <p>
	 * Uses the AfterThrowing annotation with a pointcut expression to target the UserDao 
	 * findByEmailAndPassword method. This advice will log when a user has unsuccessfully
	 * attempted to log into an account to a project2-Login-*.log file.
	 * </p>
	 * 
	 * @param JoinPoint
	 * @return void
	 */
	@AfterThrowing("execution(* com.m3.dao.UserDao.findByEmailAndPassword(..))")
	public void afterUnsuccessfulLogin(JoinPoint jp) {
		Object[] args =jp.getArgs();
		userLogger.log(Level.getLevel("LOGIN"), "Unsuccessful login attempt on user:" + args[0].toString());
	}
	/**
	 * <p>
	 * Uses the AfterReturning annotation with a pointcut expression to target the UserDao 
	 * save method. This advice will log when a user has successfully registered a new
	 * account to a project2-Register-*.log file.
	 * </p>
	 * 
	 * @param JoinPoint
	 * @return void
	 */
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
	/**
	 * <p>
	 * Uses the AfterReturning annotation with a pointcut expression to target the UserDao 
	 * save method. This advice will log when a user has successfully updated an
	 * account to a project2-AccountUpdate-*.log file.
	 * </p>
	 * 
	 * @param JoinPoint
	 * @return void
	 */
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
