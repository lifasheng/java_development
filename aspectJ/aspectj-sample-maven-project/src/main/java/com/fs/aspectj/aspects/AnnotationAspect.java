package com.fs.aspectj.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class AnnotationAspect {
    private static final Logger log = LoggerFactory.getLogger(AnnotationAspect.class);

    @Around("@annotation(com.fs.aspectj.annotations.TimeMetric) && execution(* com.fs.aspectj.App.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
        final String methodName = joinPoint.getSignature().getName();
        System.out.println("around of method: " + methodName);
        final long start = System.currentTimeMillis();
        Object result = null;
        try {
            result = joinPoint.proceed();
            result += " thank you!";
        } catch (Exception exception) {
            throw exception;
        }
        finally {
            final long end = System.currentTimeMillis();
            log.info("Time used: {}",  (end - start));
        }
        return result;
    }

}