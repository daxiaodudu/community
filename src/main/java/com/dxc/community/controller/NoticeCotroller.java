package com.dxc.community.controller;

import com.dxc.community.constant.WebConst;
import com.dxc.community.dto.NotificationDto;
import com.dxc.community.pojo.NotificationDomain;
import com.dxc.community.pojo.UserDomain;
import com.dxc.community.service.notification.NotificationService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * description: 通知 <br>
 * date: 2020/4/3 9:23 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Controller
public class NoticeCotroller {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/notice")
    public String index(
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
            HttpServletRequest httpServletRequest,
            Model model) {

        UserDomain userDomain = (UserDomain) httpServletRequest
                .getSession()
                .getAttribute(WebConst.LOGIN_SESSION_KEY);

        NotificationDomain notificationDomain = new NotificationDomain();
        notificationDomain.setStatus(1);
        notificationDomain.setReceiver(userDomain.getUid());
        PageInfo<NotificationDto> list = this.notificationService.getList(notificationDomain, pageSize, pageNo);

        model.addAttribute("list", list);

        return "notice";
    }
}
