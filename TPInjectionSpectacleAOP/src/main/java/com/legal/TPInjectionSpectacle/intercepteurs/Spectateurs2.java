package com.legal.TPInjectionSpectacle.intercepteurs;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Spectateurs2 {
	
	public Spectateurs2() {
	}
	
	@Pointcut("execution(* *.performe(..))")
	public void performance(){}
	
	@Before("performance()")
	public void etienTelephonesPortables() {
		System.out.println("Les spectateurs éteignent leurs tépéhones portables");
	}


	@AfterReturning("performance()")
	public void quittelasalle() {
		System.out.println("Les spectateurs quittent la salle");
	}
	
	
}
