package com.dxc.community.controller;

import com.dxc.community.constant.WebConst;
import com.dxc.community.dto.NotificationDto;
import com.dxc.community.pojo.NotificationDomain;
import com.dxc.community.pojo.UserDomain;
import com.dxc.community.service.notification.NotificationService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * description: RepliesController <br>
 * date: 2020/4/6 21:03 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */

@Controller
public class RepliesController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/replies")
    public String index(
            HttpServletRequest httpServletRequest,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
            Model model) {

        UserDomain userDomain = (UserDomain) httpServletRequest.getSession().getAttribute(WebConst.LOGIN_SESSION_KEY);

        NotificationDomain notificationDomain = new NotificationDomain();
        notificationDomain.setReceiver(userDomain.getUid());
        PageInfo<NotificationDto> list = notificationService.getList(notificationDomain, pageSize, pageNo);
        model.addAttribute("list", list);
        return "replies";
    }
}
