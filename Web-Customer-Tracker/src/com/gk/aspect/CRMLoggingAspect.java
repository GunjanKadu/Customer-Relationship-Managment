package com.gk.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component(value = "CRMLogging")
public class CRMLoggingAspect {

	// Setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());

	// setup pointcut declaration

	// add @Before advice

	// add @AfterReturning advice
}
