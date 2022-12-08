package com.digipay.spring.mvc;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Configuration
@EnableAspectJAutoProxy
@Aspect
@Component
public class MyAspect {
    @Before("execution(* com.digipay.spring.mvc.controller.TestController.listAllUsers(..))")
    public void userAdvice( JoinPoint joinPoint){
//        StopWatch watch = new StopWatch();
//        watch.start();
//        joinPoint.();
//        watch.stop();
        System.out.println("My Aspect invoked.");
        Arrays.stream(joinPoint.getArgs()).toList().forEach(System.out::println);

//        System.out.println("@Around: Before calculation-"+ new Date());
//        joinPoint.proceed();
//        System.out.println("@Around: After calculation-"+ new Date());
    }
}
