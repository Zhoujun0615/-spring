package com.how2java.aspect;

import org.aspectj.lang.ProceedingJoinPoint;

/**日志切面类
 * @author:Administrator
 * @date:2019/6/10 14:50
 */
public class LoggerAspect {

    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start log: " + joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        System.out.println("end log: " + joinPoint.getSignature().getName());
        return  object;
    }
}
