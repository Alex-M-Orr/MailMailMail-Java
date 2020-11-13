package com.m3.aspect;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;



/**
 * 
 * <h1>UserAspect</h1>
 * <p>
 * The UserAspect is used to log any time an exception is thrown.
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
public class GeneralAspect {
	
	/**
	 * This field is an instance of a Log4j Logger, which is used to log information
	 * to the log files.
	 */
	
	private static Logger generalLogger = LogManager.getLogger(GeneralAspect.class);

	/**
	 * <p>
	 * Uses the AfterThrowing annotation with a pointcut expression to target the any
	 * method in any class in any package under the m3 folder. This advice will log 
	 * any exception thrown to a project2-Exceptions-*.log file.
	 * </p>
	 * 
	 * @param JoinPoint
	 * @return void
	 */
	
	@AfterThrowing("execution(* com.m3.*.*.*(..))")
	public void anyExcpetionThrown(JoinPoint jp) {
		Object[] args =jp.getArgs();
		String sig = jp.getSignature().toString();
		System.out.println(sig);
		String msg = "";
		for(Object i: args) {
			msg+=i.toString() + " ";
		}
		generalLogger.log(Level.getLevel("GENEXCEP"), sig + " threw an exception with args: " + msg);

	}
	
}
