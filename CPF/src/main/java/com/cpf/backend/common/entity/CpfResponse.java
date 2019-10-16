package com.cpf.backend.common.entity;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class CpfResponse {
    /**
     * 请求是否成功
     */
    private boolean success;
    /**
     * 成功或者失败的code错误码
     */
    private String code;
    /**
     * 成功时返回的数据，失败时返回具体的异常信息
     */
    private Object data;
    /**
     * 请求失败返回的提示信息，给前端进行页面展示的信息
     */
    private Object Message;
    /**
     * 服务器当前时间（添加该字段的原因是便于查找定位请求时间，因为实际开发过程中服务器时间可能跟本地时间不一致，加上这个时间戳便于日后定位）
     */
    private Timestamp currentTime;

    public CpfResponse() {
    }

    public CpfResponse(boolean success, String code, Object data, Object errorMessage) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.Message = errorMessage;
        this.currentTime = new Timestamp(System.currentTimeMillis());
    }
    @Override
    public String toString() {
        return "RestResult{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", data=" + data +
                ", Message=" + Message +
                ", currentTime=" + currentTime +
                '}';
    }
}
