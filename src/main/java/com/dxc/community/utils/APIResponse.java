package com.dxc.community.utils;

/**
 * description: APIResponse <br>
 * date: 2020/3/12 13:59 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
public class APIResponse<T> {
    private static final String CODE_SUCCESS = "success";

    private static final String CODE_FAIL = "fail";

    private String code;
    private T data;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public APIResponse() {
    }

    public APIResponse(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public APIResponse(String code, T data) {
        this.code = code;
        this.data = data;
    }

    public static APIResponse success(String msg) {
        return new APIResponse(CODE_SUCCESS, msg);
    }

    public static APIResponse success(Object data) {
        return new APIResponse(CODE_SUCCESS, data);
    }


    public static APIResponse fail(String msg) {
        return new APIResponse(CODE_FAIL, msg);
    }

    public static APIResponse fail(Object data) {
        return new APIResponse(CODE_FAIL, data);
    }
}

