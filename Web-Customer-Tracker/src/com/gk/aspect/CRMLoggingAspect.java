package com.gk.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component(value = "CRMLogging")
public class CRMLoggingAspect {

	// Setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declaration
	@Pointcut("execution(* com.gk.springdemo.controller.*.*(..))")
	private void forControllerPackage() {
	}

	@Pointcut("execution(* com.gk.service.*.*(..))")
	private void forServicePackage() {
	}

	@Pointcut("execution(* com.gk.dao.*.*(..))")
	private void forDaoPackage() {
	}

	// Combining Point Cut declaration
	@Pointcut("forControllerPackage()||forServicePackage()||forDaoPackage()")
	private void forAppFlow() {
	}

	// add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		// display the methods we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>>> in @Before:calling method: " + theMethod);

		// display the arguments to the method

		// get the arguments
		Object[] args = theJoinPoint.getArgs();

		// loop thru arguments
		for (Object tempArg : args) {
			myLogger.info("======> argument: " + tempArg);
		}

	}

	// add @AfterReturning advice
	@AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("====>>> in @AfterReturning:from method: " + theMethod);

		// display the data returned
		myLogger.info("=====>> result: " + theResult);

	}

}
