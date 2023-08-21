package com.wo.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wo.enums.ErrorCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {
    /**
     * 响应码
     */
    private Integer code;
    /**
     * 响应消息
     */
    private String message;
    /**
     * 响应数据
     */
    private T data ;
    /**
     * 操作成功。
     * @param message 响应消息
     * @return 200状态码
     * @param <T> 泛型
     */
    public static <T> Result<T> ok(String message){
        return create(200,message,null);
    }
    /**
     * 操作成功。
     * @param message 响应消息
     * @param data 响应数据
     * @return 200状态码
     * @param <T> 泛型
     */
    public static <T> Result<T> ok(String message, T data){
        return create(200,message,data);
    }
    /**
     * 生成了新的资源。
     * @param message 响应消息
     * @return 201状态码
     * @param <T> 泛型
     */
    public static <T> Result<T> created(String message){
        return create(201,message,null);
    }
    /**
     * 生成了新的资源。
     * @param message 响应消息
     * @param data 响应数据
     * @return 201状态码
     * @param <T> 泛型
     */
    public static <T> Result<T> created(String message, T data){
        return create(201,message,data);
    }
    /**
     * 资源已经不存在。
     * @param message 响应消息
     * @return 204状态码
     * @param <T> 泛型
     */
    public static <T> Result<T> noContent(String message){
        return create(204,message,null);
    }
    /**
     * 资源已经不存在。
     * @param message 响应消息
     * @param data 响应数据
     * @return 204状态码
     * @param <T> 泛型
     */
    public static <T> Result<T> noContent(String message,T data){
        return create(204,message,data);
    }
    /**
     * 操作失败。
     * @param message 响应消息
     * @return 400状态码
     * @param <T> 泛型
     */
    public static <T> Result<T> error(String message){
        return create(400,message,null);
    }
    /**
     * 操作失败。
     * @param message 响应消息
     * @param data 响应数据
     * @return 400状态码
     */
    public static <T> Result<T> error(String message,T data){
        return create(400,message,data);
    }
    public static <T> Result<T> error(ErrorCodeEnum errorCodeEnum,T data){
        Result<T> result = new Result<>();
        result.setCode(errorCodeEnum.getCode());
        result.setMessage(errorCodeEnum.getMessage());
        result.setData(data);
        return result;
    }
    public static <T> Result<T> error(ErrorCodeEnum errorCodeEnum){
        Result<T> result = new Result<>();
        result.setCode(errorCodeEnum.getCode());
        result.setMessage(errorCodeEnum.getMessage());
        return result;
    }

}
