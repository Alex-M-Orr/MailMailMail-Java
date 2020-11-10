package com.m3.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class UserAspect {
	
	@AfterReturning("execution(* com.m3.dao.UserDao.findByEmailAndPassword(..))")
	public void afterSuccessfulLogin(JoinPoint jp) {
		System.out.println("Advice after successfull login :)");
	}
	@AfterThrowing("execution(* com.m3.dao.UserDao.findByEmailAndPassword(..))")
	public void afterUnsuccessfulLogin(JoinPoint jp) {
		System.out.println("Advice after unsuccessfull login :(");
	}
	@AfterReturning("execution(* com.m3.dao.UserDao.save(..))")
	public void afterRegister() {
		System.out.println("Advice after successfull register");
	}
}
