package com.legal.TPInjectionSpectacle.intercepteurs;

import org.aspectj.lang.ProceedingJoinPoint;

public class Musiciens {

	public Musiciens(){}
	
//	public void jejoue(){
//		System.out.println("----- Je joue");
//		
//	}
	
	public Object jejoue(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("----- Je joue ");
		return pjp.proceed();
	}
	
	
}
