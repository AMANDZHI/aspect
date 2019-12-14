package amandzhi.aspect.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class MyAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(public * amandzhi.aspect.CoachService.*(..))")
    public void callCoachServicePublic() { }

    @Before("callCoachServicePublic()")
    public void beforeCall(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs()).map(a -> a.toString()).collect(Collectors.joining(","));
        logger.info("before " + jp.toString() + ", args=[" + args + "]");
    }

    @After("callCoachServicePublic()")
    public void afterCallAt(JoinPoint jp) {
        String args = Arrays.stream(jp.getArgs()).map(a -> a.toString()).collect(Collectors.joining(","));
        logger.info("after " + jp.toString() + ", args=[" + args + "]");
    }

    @AfterReturning(pointcut = "callCoachServicePublic()", returning = "returnVal")
    public void afterReturnCallAt(String returnVal) {
        logger.info("after return: " + returnVal);
    }
}
