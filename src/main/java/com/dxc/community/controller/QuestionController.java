package com.dxc.community.controller;

import com.dxc.community.dto.QuestionDto;
import com.dxc.community.exception.BusinessException;
import com.dxc.community.pojo.Qcomments;
import com.dxc.community.service.comments.CommentsService;
import com.dxc.community.service.questions.QuestionsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

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

    @Autowired
    private CommentsService commentsService;


    @GetMapping("/question/{id}")
    public String question(@PathVariable("id") Integer id,
                           Model model) {

        QuestionDto questionDto = questionsService.getById(id);

        //增加点击量
        questionsService.hitViewCount(id);


        //回复列表
        PageInfo<Qcomments> qcommentsPageInfo = commentsService.getListByParentId(questionDto.getQid().longValue(), 1, 10000, 1);


        model.addAttribute("questionDto", questionDto);
        model.addAttribute("qcommentsPageInfo", qcommentsPageInfo);
        return "question";
    }

    @GetMapping("/question/secondReply/{cid}")
    public String secondReply(@PathVariable("cid") Long cid, Model model) {
        PageInfo<Qcomments> listByParentId = commentsService.getListByParentId(cid, 2, 10000, 1);
        model.addAttribute("secondReplyList", listByParentId.getList());

        return "comm/second_reply::secondReply";

    }

}
