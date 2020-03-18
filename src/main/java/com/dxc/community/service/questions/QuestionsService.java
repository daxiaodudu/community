package com.dxc.community.service.questions;

import com.dxc.community.dto.QuestionDto;
import com.dxc.community.dto.ResultInfo;
import com.dxc.community.pojo.QuestionDomain;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * description: QuestionsService <br>
 * date: 2020/3/13 14:13 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
public interface QuestionsService {

    //添加
    ResultInfo addQuestion(QuestionDomain questionDomain);

    void deleteQuestion(Integer qid);

    PageInfo<QuestionDto> getList(QuestionDomain questionDomain, Integer pageSize, Integer pageNo);


    QuestionDto getById(Integer qid);

}
