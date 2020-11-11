package com.m3.aspect;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class GeneralAspect {
	
	private static Logger generalLogger = LogManager.getLogger(PostAspect.class);

	
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
