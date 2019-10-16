package com.cpf.backend.common.handler;

import com.alibaba.fastjson.JSONObject;
import com.cpf.backend.common.entity.CpfResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
@Slf4j
@ControllerAdvice(basePackages={"com.cpf.backend.user.controller","com.cpf.backend.bill.controller","com.cpf.backend.origin.controller"})
public class ResponseHandler implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        CpfResponse rep= new CpfResponse(true,"SYS00000",o,"交易成功");
        log.info("Response："+JSONObject.toJSON(rep).toString());
        return JSONObject.toJSON(rep);
    }
}
