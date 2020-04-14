package com.example.demo.login.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

  // @Before("execution(*
  // com.example.demo.login.controller.LoginController.getLogin(..))")
  // public void StartLog(JoinPoint jp) {
  // System.out.println("メソッド開始：" + jp.getSignature());
  // }

  // @After("execution(*
  // com.example.demo.login.controller.LoginController.getLogin(..))")
  // public void endLog(JoinPoint jp) {
  // System.out.println("メソッド終了：" + jp.getSignature());
  // }

  @Around("execution(* *..*.*Controller.*(..))")
  public Object startLog(ProceedingJoinPoint jp) throws Throwable {
    System.out.println("メソッド開始：" + jp.getSignature());

    try {
      Object result = jp.proceed();
      System.out.println("メソッド終了：" + jp.getSignature());
      return result;
    } catch (Exception e) {
      System.out.println("メソッド異常終了：" + jp.getSignature());
      e.printStackTrace();
      throw e;
    }
  }

  @Around("execution(* *..*.*UserDao*.*(..))")
  public Object daoLog(ProceedingJoinPoint jp) throws Throwable {
    System.out.println("メソッド開始：" + jp.getSignature());

    try {
      Object result = jp.proceed();
      System.out.println("メソッド終了：" + jp.getSignature());
      return result;
    } catch (Exception e) {
      System.out.println("メソッド異常終了：" + jp.getSignature());
      e.printStackTrace();
      throw e;
    }
  }
}