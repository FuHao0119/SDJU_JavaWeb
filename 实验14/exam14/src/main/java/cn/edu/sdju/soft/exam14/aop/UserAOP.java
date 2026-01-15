package cn.edu.sdju.soft.exam14.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Map;

@Slf4j
@Aspect
@Component
public class UserAOP {
    String requestURL;
    String parameterMapString;
    long startTime;

    @Pointcut("execution(* cn.edu.sdju.soft.exam14.controller.*.*(..))")
    void aPoint() {}

    @Before("aPoint()")
    void takeOffCloth(JoinPoint jPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attributes != null) {
            HttpServletRequest request = attributes.getRequest();
            requestURL = request.getRequestURL().toString();
            Map<String, String[]> parameterMap = request.getParameterMap();
            Object[] args = jPoint.getArgs();
            parameterMapString = Arrays.toString(args);
            startTime =  System.currentTimeMillis();
        }
    }

    @AfterReturning(value = "aPoint()", returning = "result")
    void putOnCloth(JoinPoint jPoint, Object result) {
        long consume =  System.currentTimeMillis() - startTime;
        log.info("请求路径为: " + requestURL + " 请求参数为: " + parameterMapString + " 响应结果为: " + result + " 耗时: " + consume + " ms");
    }
}
