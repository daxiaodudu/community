package com.dxc.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: ResultInfo <br>
 * date: 2020/3/13 16:47 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */

public class ResultInfo {
    private boolean isSuccess;
    private String msg;

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


    public ResultInfo(boolean isSuccess, String msg) {
        this.isSuccess = isSuccess;
        this.msg = msg;
    }

    public static ResultInfo success(String msg) {
        return new ResultInfo(true, msg);
    }

    public static ResultInfo success() {
        return success("操作成功");
    }


    public static ResultInfo fail(String msg) {
        return new ResultInfo(false, msg);
    }

    public static ResultInfo fail() {
        return fail("操作失败");
    }
}
