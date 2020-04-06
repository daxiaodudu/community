package com.dxc.community.config;

import com.dxc.community.constant.WebConst;
import com.dxc.community.pojo.UserDomain;
import com.dxc.community.service.notification.NotificationService;
import com.dxc.community.service.user.UserService;
import com.dxc.community.utils.DuDuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * description: MyInterception <br>
 * date: 2020/3/16 13:42 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Service
public class MyInterception implements HandlerInterceptor {
    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Integer uid = DuDuUtils.getCookieUid(request);
        if (null != uid) {
            UserDomain userDomain = userService.getUserByid(uid);
            request.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, userDomain);
            request.setAttribute("getUnreadCount", notificationService.getUnread(userDomain.getUid()));
        } else {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
