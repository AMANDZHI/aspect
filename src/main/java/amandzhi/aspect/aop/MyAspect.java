package amandzhi.aspect.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Aspect
@Component
public class MyAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ValidService validService;

//    @Pointcut("execution(public * amandzhi.aspect.CoachService.*(..))")
//    public void callCoachServicePublic() { }

    @Pointcut("@annotation(SecurityAnnotation) && args(password)")
    public void secure(String password) { }

//    @Before("callCoachServicePublic()")
//    public void beforeCall(JoinPoint jp) {
//        String args = Arrays.stream(jp.getArgs()).map(a -> a.toString()).collect(Collectors.joining(","));
//        logger.info("before " + jp.toString() + ", args=[" + args + "]");
//    }
//
//    @After("callCoachServicePublic()")
//    public void afterCallAt(JoinPoint jp) {
//        String args = Arrays.stream(jp.getArgs()).map(a -> a.toString()).collect(Collectors.joining(","));
//        logger.info("after " + jp.toString() + ", args=[" + args + "]");
//    }
//
//    @AfterReturning(pointcut = "callCoachServicePublic()", returning = "returnVal")
//    public void afterReturnCallAt(String returnVal) {
//        logger.info("after return: " + returnVal);
//    }

    @Around("secure(password)")
    public void aroundSecure(ProceedingJoinPoint pjp, String password) throws Throwable {
        logger.info("enter psw args:" +  password);

        if (validService.check(password)){
            pjp.proceed();
        } else {
            logger.info("enter not valid psw args:" +  password);
        }
    }
}
