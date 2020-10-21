package com.jongyeon.introduce.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
    Logger logger =  LoggerFactory.getLogger(LogAspect.class);

    @Around("execution(* com.jongyeon.introduce.controller.*.*(..))")
    public Object ControllerLogging(ProceedingJoinPoint pjp) throws Throwable{
        logger.info("Request - "+pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        Object result = pjp.proceed();
        logger.info("Response - " + pjp.getSignature().getDeclaringTypeName() + " / " + pjp.getSignature().getName());
        return result;
    }
}
