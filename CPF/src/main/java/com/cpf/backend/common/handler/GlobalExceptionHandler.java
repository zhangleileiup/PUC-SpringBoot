package com.cpf.backend.common.handler;

import com.alibaba.fastjson.JSONObject;
import com.cpf.backend.common.entity.BusinessException;
import com.cpf.backend.common.entity.CpfResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局处理异常类
 */

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Object handleException(Exception e) {
        CpfResponse resp= new CpfResponse(false,"SYS00001",e.getMessage(),"系统异常，请稍后再试");
        if(e instanceof BusinessException){
            BusinessException businessException= (BusinessException) e;
            resp.setCode(businessException.getCode());
            resp.setMessage(businessException.getErrorMsg());
            log.error("code:"+businessException.getCode());
            log.error("message:"+businessException.getErrorMsg());
        } else{
            log.error("code：SYS00001");
            log.error("系统异常，请稍后再试");
            log.error("message:",e);
        }
        return JSONObject.toJSON(resp);
    }
}
