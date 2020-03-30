package com.dxc.community.controller;

import com.dxc.community.constant.ErrorConstant;
import com.dxc.community.constant.WebConst;
import com.dxc.community.dto.CommentsDto;
import com.dxc.community.exception.BusinessException;
import com.dxc.community.pojo.Qcomments;
import com.dxc.community.pojo.UserDomain;
import com.dxc.community.service.comments.CommentsService;
import com.dxc.community.utils.APIResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
        if (null == userDomain)
            throw new BusinessException(ErrorConstant.Common.LOGIN_IS_EMPTY);
        commentsDto.setCreator(userDomain.getUid());
        commentsService.insertComment(commentsDto);

        return APIResponse.success("操作成功");
    }

    @RequestMapping(value = "/like", method = RequestMethod.POST)
    public Object hitLike(@RequestBody Qcomments qcomments) {
        commentsService.updateLikeComment(qcomments.getCid());

        return APIResponse.success("操作成功");
    }

    @GetMapping("/secondReply/{cid}")
    public String  secondReply(@PathVariable("cid") Long cid, Model model) {
     //  PageInfo<Qcomments> listByParentId = commentsService.getListByParentId(1L, 1, 10000, 1);
     //   model.addAttribute("secondReplyList", listByParentId.getList());

        List<String> list = new ArrayList<>(10);
        for(int i=0;i<10;i++){
            list.add("hello"+i);
        }
        model.addAttribute("aa",list);
        return "question::dxc";

    }
}
