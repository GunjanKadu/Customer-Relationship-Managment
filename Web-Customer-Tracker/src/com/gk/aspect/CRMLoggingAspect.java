package com.gk.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component(value = "CRMLogging")
public class CRMLoggingAspect {

	// Setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declaration
	@Pointcut("execution(* com.gk.springdemo.controller.*.*.(..))")
	private void forControllerPackage() {}
	
	@Pointcut("execution(* com.gk.service.*.*.(..))")
	private void forServicePackage() {}
	
	@Pointcut("execution(* com.gk.dao.*.*.(..))")
	private void forDaoPackage() {}
	
	//Combining Point Cut declaration
	@Pointcut("forControllerPackage||forServicePackage||forDaoPackage")
	private void forAppFlow() {}
	// add @Before advice

	// add @AfterReturning advice
}
