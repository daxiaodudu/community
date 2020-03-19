package com.dxc.community.advice;

import com.dxc.community.constant.ErrorConstant;
import com.dxc.community.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * description: BussinessControllerAdvice <br>
 * date: 2020/3/19 16:49 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@ControllerAdvice
public class BusinessControllerAdvice  {

    @ExceptionHandler(Exception.class)
    ModelAndView handleControllerException(HttpServletRequest request,
                                           Throwable ex,
                                           Model model) {
        if (ex instanceof BusinessException) {
            model.addAttribute("msg", ex.getMessage());
        } else {
            model.addAttribute("msg", ErrorConstant.EXCEPTION.COMM_MSG);
        }
        HttpStatus status = getStatus(request);

        return new ModelAndView("error");
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
