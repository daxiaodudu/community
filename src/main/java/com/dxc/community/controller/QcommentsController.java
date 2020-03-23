package com.dxc.community.controller;

import com.dxc.community.constant.WebConst;
import com.dxc.community.dto.CommentsDto;
import com.dxc.community.pojo.UserDomain;
import com.dxc.community.service.comments.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * description: QcommentsController <br>
 * date: 2020/3/23 10:19 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@RestController
@RequestMapping("/comments")
public class QcommentsController {

    @Autowired
    private CommentsService commentsService;

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public Object post(@RequestBody CommentsDto commentsDto,
                       HttpServletRequest httpServletRequest) {


        UserDomain userDomain = (UserDomain) httpServletRequest.getSession()
                .getAttribute(WebConst.LOGIN_SESSION_KEY);
        commentsDto.setCreator(userDomain.getUid());

        commentsService.insertComment(commentsDto);
        return null;
    }
}
