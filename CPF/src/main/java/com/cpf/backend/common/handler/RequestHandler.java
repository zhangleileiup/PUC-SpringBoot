package com.cpf.backend.common.handler;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Aspect
@Component
public class RequestHandler{
    @Pointcut("execution( public * com.cpf.backend.*.controller.*.*(..))")
    public void handlerRequest(){

    }

    /**
     * 前置通知：在连接点之前执行的通知
     * @param joinPoint
     */
    @Before("handlerRequest()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes Attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request =Attributes.getRequest();
        //请求路径
        log.info("url:{}",request.getRequestURL());
        //请求方式
        log.info("method:{}",request.getMethod());
        //请求ip
        log.info("ip:{}",request.getRemoteAddr());
        //类方法
        log.info("class_method:{}",joinPoint.getSignature().getDeclaringTypeName()+"."+ joinPoint.getSignature().getName());
        //请求参数
        log.info("Request:{}", JSONObject.toJSONString(joinPoint.getArgs()));
    }

    /**
     * 后置最终通知（目标方法只要执行完了就会执行后置通知方法）
     */
    @After("handlerRequest()")
    public void doAfter(){

    }

    /**
     * 后置返回通知
     */
    @AfterReturning("handlerRequest()")
    public void doAfterReturning(){

    }
}
