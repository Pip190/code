package com.wo.enums;


import lombok.Getter;

@Getter
public enum ErrorCodeEnum {
    PARAM_ERROR(400, "参数错误");
    private final Integer code;
    private final String message;
    ErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
