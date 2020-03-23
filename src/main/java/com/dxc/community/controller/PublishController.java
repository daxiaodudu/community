package com.dxc.community.controller;

import com.dxc.community.constant.WebConst;
import com.dxc.community.dto.QuestionDto;
import com.dxc.community.dto.ResultInfo;
import com.dxc.community.pojo.QuestionDomain;
import com.dxc.community.pojo.UserDomain;
import com.dxc.community.service.questions.QuestionsService;
import com.dxc.community.utils.DuDuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * description: publishController <br>
 * date: 2020/3/13 11:42 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Controller
public class PublishController {

    @Autowired
    private QuestionsService questionsService;

    @GetMapping("publish")
    public String publish(Model model) {
        model.addAttribute("questionDto", new QuestionDto());
        return "publish";
    }

    @GetMapping("publish/{id}")
    public String edit(@PathVariable("id") Integer id,
                       Model model) {

        QuestionDto questionDto = questionsService.getById(id);

        model.addAttribute("questionDto", questionDto);
        return "publish";
    }

    @PostMapping("publish")
    public String insert(QuestionDomain questionDomain,
                         HttpServletRequest httpServletRequest,
                         Model model) {

        ResultInfo resultInfo;

        UserDomain userDomain = (UserDomain) httpServletRequest.getSession()
                .getAttribute(WebConst.LOGIN_SESSION_KEY);

        questionDomain.setCreator(userDomain.getUid());

        if (questionDomain.getQid() == null) {
            resultInfo = questionsService.addQuestion(questionDomain);
        } else {
            resultInfo = questionsService.editQuestion(questionDomain);
        }

        if (!resultInfo.isSuccess()) {
            model.addAttribute("publishError", resultInfo.getMsg());
            return "publish";
        } else {
            return "redirect:/";
        }

    }
}
