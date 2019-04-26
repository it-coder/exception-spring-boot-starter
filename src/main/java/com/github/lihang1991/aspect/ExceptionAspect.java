package com.github.lihang1991.aspect;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.lihang1991.handle.ExceptionHandler;

/**
 * @author lih
 * @date 2019-04-19-19:23.
 */
//@Aspect
//@Configuration
public class ExceptionAspect {

    private static final Logger log = LoggerFactory.getLogger(ExceptionAspect.class);

   private ExceptionHandler exceptionHandler;

    public ExceptionAspect(ExceptionHandler exceptionHandler) {
        this.exceptionHandler = exceptionHandler;
    }

    @AfterThrowing(pointcut = "execution(* com.lihang.exception.controller.*.*(..))", throwing = "e")
    public void exceptionNoticeWithMethod(JoinPoint joinPoint, RuntimeException e) {
        log.debug("======================:{} --> {}", joinPoint.getSignature().getName(), joinPoint.getArgs());
        handleException(e, joinPoint.getSignature().getName(), joinPoint.getArgs());
    }

    private void handleException(RuntimeException exception, String methodName, Object[] args) {
        log.debug("出现异常：" + methodName + String.join(",", Arrays.stream(args).map(x -> x.toString()).toArray(String[]::new)));
        exceptionHandler.createNotice(exception, methodName, args);
    }


}
