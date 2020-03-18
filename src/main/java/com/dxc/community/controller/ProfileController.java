package com.dxc.community.controller;

import com.dxc.community.constant.WebMapAction;
import com.dxc.community.dto.QuestionDto;
import com.dxc.community.pojo.QuestionDomain;
import com.dxc.community.service.questions.QuestionsService;
import com.dxc.community.utils.DuDuUtils;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * description: ProfileController <br>
 * date: 2020/3/15 13:32 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Controller
public class ProfileController {

    @Autowired
    private QuestionsService questionsService;

    @GetMapping("/profile/{action}")
    public String profile(
            HttpServletRequest httpServletRequest
            , @PathVariable(name = "action") String action
            , @RequestParam(name = "pageNo",defaultValue = "1") int pageNo
            , @RequestParam(name = "pageSize",defaultValue = "10") int pageSize
            , Model model) {

        action = StringUtils.isBlank(action) ? "myQuestion" : action;
        QuestionDomain questionDomain = new QuestionDomain();

        PageInfo<QuestionDto> list = questionsService.getList(questionDomain, pageSize, pageNo);

        model.addAttribute("profileValue", WebMapAction.ProfileMap.get(action));
        model.addAttribute("profileName", action);
        model.addAttribute("list", list);
        return "profile";
    }
}
