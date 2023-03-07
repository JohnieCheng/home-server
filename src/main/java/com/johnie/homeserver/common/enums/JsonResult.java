package com.johnie.homeserver.common.enums;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class JsonResult<T> implements Serializable {
    private Boolean success;
    private Integer errorCode;
    private String errorMsg;
    private T data;

    public JsonResult(boolean success, T data) {
        this.success = success;
        this.errorCode = success ? ErrorCode.SUCCESS.getCode() : ErrorCode.FAIL.getCode();
        this.errorMsg = success ? ErrorCode.SUCCESS.getMessage() : ErrorCode.FAIL.getMessage();
        this.data = data;
    }

    public JsonResult(boolean success, ErrorCode resultEnum, T data) {
        this.success = success;
        this.errorCode = success ? ErrorCode.SUCCESS.getCode() : (resultEnum == null ? ErrorCode.FAIL.getCode() : resultEnum.getCode());
        this.errorMsg = success ? ErrorCode.SUCCESS.getMessage() : (resultEnum == null ? ErrorCode.FAIL.getMessage() : resultEnum.getMessage());
        this.data = data;
    }

}
