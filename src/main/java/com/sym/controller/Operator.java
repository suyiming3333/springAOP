package com.sym.controller;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Package: com.sym.controller
 * @fileName: Operator
 * @Description:
 * @Author Suyiming3333@gmail.com
 * @Created in 14:28 2018/3/31 0031
 */

@Component
@Aspect//切面 通常是一个类，可定义切入点和通知
public class Operator {


    //切入点：就是带有通知的连接点，在程序中主要体现为书写切入点表达式
    @Pointcut("execution(* com.sym.service..*.*(..))")
    public void pointCut(){
            System.out.println("enter pointCut ");
    }



    //advice(通知):AOP在特定的切入点上执行的增强处理，有before,after,afterReturning,afterThrowing,around

//    A:@Pointcut("execution(* com.aijava.springcode.service..*.*(..))")
//
//    第一个*表示匹配任意的方法返回值，..(两个点)表示零个或多个，上面的第一个..表示service包及其子包,第二个*表示所有类,第三个*表示所有方法，第二个..表示
//
//            方法的任意参数个数
//
//    B:@Pointcut("within(com.aijava.springcode.service.*)")
//
//    within限定匹配方法的连接点,上面的就是表示匹配service包下的任意连接点
//
//    C:@Pointcut("this(com.aijava.springcode.service.UserService)")
//
//    this用来限定AOP代理必须是指定类型的实例，如上，指定了一个特定的实例，就是UserService
//
//    D:@Pointcut("bean(userService)")
//
//    bean也是非常常用的,bean可以指定IOC容器中的bean的名称
    @Before("pointCut()")
    public void beforeAdvice(JoinPoint joinPoint){//jointpoint 程序执行过程中明确的点，一般是方法的调用
        System.out.println("AOP before advice");
    }

    @After("pointCut()")
    public void afterAdvice(JoinPoint joinPoint){
        System.out.println("AOP after advice");
    }

    @AfterReturning(pointcut = "pointCut()",returning = "returnVal")
    public void afterReturning(JoinPoint joinPoint,Object returnVal){
        System.out.println("AOP AfterReturning Advice:" + returnVal);
    }

    @AfterThrowing(pointcut="pointCut()",throwing="error")
    public void afterThrowing(JoinPoint joinPoint,Throwable error){
        System.out.println("AOP AfterThrowing Advice..." + error);
        System.out.println("AfterThrowing...");
    }

    @Around("pointCut()")//环绕通知 在目标方法完成前后做增强处理,环绕通知是最重要的通知类型,像事务,日志等都是环绕通知,注意编程中核心是一个ProceedingJoinPoint
    public void around(ProceedingJoinPoint pjp){
        System.out.println("AOP Aronud before...");
        try {
            pjp.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("AOP Aronud after...");
    }

}
