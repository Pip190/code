package com.wo.enums;


public enum ErrorCodeEnum {
    PARAM_ERROR(400, "参数错误");
    private Integer code;
    private String message;
    ErrorCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
