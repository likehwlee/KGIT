package com.team404.util.aop;


import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LogAdvice {
	//로그를 찍을 수 있게 처리하는 기능
	private static final Logger log = LoggerFactory.getLogger(LogAdvice.class);
	//이프로젝트의 모든 서비스에 대해서, target, args, signature의 실행정보를 출력하는 aop
	@Around("execution(* com.team404.*.service.*ServiceImpl.*(..))")
	public Object around(ProceedingJoinPoint jp) {
		long start = System.currentTimeMillis();
		Object result= null;
		
		log.info("적용클래스:"+jp.getTarget());
		log.info("적용파라미터"+Arrays.toString(jp.getArgs()));
		log.info("적용메서드" + jp.getSignature());
		
		
		System.out.println("sdfsdf");
		try {
			result = jp.proceed();
		}catch (Throwable e) {
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		log.info("메서드수행시간"+(end-start)*0.001+"초");
		
		return result;
	}
	

}
