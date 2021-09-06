package com.example.multidb.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author Kelvin Chen
 * @date 2021-08-15 20:33:07
 */
@Aspect
@Component
public class DataSourceAop {

    @Before("execution(* com.example.multidb.service.impl.*.*(..))")
    public void before(JoinPoint joinpoint) {
        String methodName = joinpoint.getSignature().getName();
        if (StringUtils.startsWithAny())
    }
}
