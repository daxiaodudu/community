package com.dxc.community.exception;

import com.dxc.community.utils.APIResponse;

/**
 * description: BusinessException <br>
 * date: 2020/3/12 13:58 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
public class BusinessException extends RuntimeException {
    protected String errorCode;
    protected String[] errorMessageArguments;
    protected APIResponse apiResponse;

    private BusinessException() {
        this("");
    }


    public BusinessException(String message) {
        super(message);
        this.errorCode = "fail";
        errorMessageArguments = new String[0];
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
        this.errorCode = "fail";
        this.errorMessageArguments = new String[0];
    }

    public static BusinessException withErrorCode(String errorCode) {
        BusinessException exception = new BusinessException();
        exception.errorCode = errorCode;
        return exception;
    }


}
