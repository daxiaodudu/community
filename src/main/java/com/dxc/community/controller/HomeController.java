package com.dxc.community.controller;

import com.dxc.community.constant.WebConst;
import com.dxc.community.dto.QuestionDto;
import com.dxc.community.pojo.QuestionDomain;
import com.dxc.community.pojo.UserDomain;
import com.dxc.community.service.questions.QuestionsService;
import com.dxc.community.service.user.UserService;
import com.dxc.community.utils.DuDuUtils;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * description: HomeController <br>
 * date: 2020/3/11 11:21 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    private QuestionsService questionsService;

    @GetMapping({"/", "home", "Home/Index"})
    public String Index(
            HttpServletRequest httpServletRequest,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(value = "pageNo", defaultValue = "1") int pageNo
            , Model model) {

        PageInfo<QuestionDto> list = questionsService.getList(new QuestionDomain(), pageSize, pageNo);
        model.addAttribute("list", list);
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/loginOut")
    public String loginOut(HttpServletRequest httpServletRequest
            , HttpServletResponse httpServletResponse) {

        Cookie cookie = new Cookie(WebConst.USER_IN_COOKIE, null);
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
        return "redirect:/";
    }

    @PostMapping("/LoginTo")
    public String LoginTo(
            @RequestParam("username") String username,
            @RequestParam("pwd") String pwd,
            HttpServletRequest httpServletRequest,
            HttpServletResponse httpServletResponse) {

        UserDomain userDomain = new UserDomain();
        userDomain.setPassword(pwd);
        userDomain.setUsername(username);
        userDomain = userService.getUser(userDomain);
        httpServletResponse.addCookie(new Cookie(WebConst.USER_IN_COOKIE, userDomain.getUid().toString()));
        if (null != userDomain) {
            httpServletRequest.getSession().setAttribute(WebConst.LOGIN_SESSION_KEY, userDomain);
        } else {
            httpServletRequest.getSession().removeAttribute(WebConst.LOGIN_SESSION_KEY);
        }
        return "redirect:/";
    }


}
