package com.cpf.backend.common.entity;

import lombok.Data;

@Data
public class BusinessException extends RuntimeException {
    private String code;
    private String errorMsg;


    private BusinessException(String code,String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }
    public BusinessException(String code)
    {
        this.code = code;
    }
    /**
     * 抛出逻辑异常
     */
    public static BusinessException throwBusinessException(String code) {
        throw new BusinessException(code);
    }
    public static BusinessException throwBusinessException(String code,String errorMsg) {
        throw new BusinessException(code,errorMsg);
    }
}
