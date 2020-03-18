package com.dxc.community.controller;

import com.dxc.community.dto.QuestionDto;
import com.dxc.community.service.questions.QuestionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * description: QuestionController <br>
 * date: 2020/3/18 11:22 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Controller
public class QuestionController {

    @Autowired
    private QuestionsService questionsService;

    @GetMapping("/question/{id}")
    public String question(@PathVariable("id") Integer id,
                           Model model) {

        QuestionDto questionDto = questionsService.getById(id);

        model.addAttribute("questionDto",questionDto);

        return "question";
    }
}
