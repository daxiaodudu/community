package com.dxc.community.advice;

import com.alibaba.fastjson.JSON;
import com.dxc.community.constant.ErrorConstant;
import com.dxc.community.exception.BusinessException;
import com.dxc.community.utils.APIResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * description: BussinessControllerAdvice <br>
 * date: 2020/3/19 16:49 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@ControllerAdvice
public class BusinessControllerAdvice {

    @ExceptionHandler(Exception.class)
    ModelAndView handleControllerException(HttpServletRequest request,
                                           HttpServletResponse response,
                                           Throwable ex,
                                           Model model) {

        if (StringUtils.equals(request.getContentType(), "application/json")) {

            String msg;
            if (ex instanceof BusinessException) {
                msg = ex.getMessage();
            } else {
                msg = ErrorConstant.EXCEPTION.COMM_MSG;
            }
            response.setStatus(200);
            response.setCharacterEncoding("utf-8");
            response.setContentType("application/json");
            PrintWriter writer = null;
            try {
                writer = response.getWriter();
                writer.write(JSON.toJSONString(APIResponse.fail(msg)));
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        } else {

            if (ex instanceof BusinessException) {
                model.addAttribute("msg", ex.getMessage());
            } else {
                model.addAttribute("msg", ErrorConstant.EXCEPTION.COMM_MSG);
            }
            HttpStatus status = getStatus(request);

            return new ModelAndView("error");
        }
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
