package com.dxc.community.service.questions.impl;


import com.dxc.community.constant.ErrorConstant;
import com.dxc.community.constant.WebConst;
import com.dxc.community.dao.QuestionsDao;
import com.dxc.community.dto.QuestionDto;
import com.dxc.community.dto.ResultInfo;
import com.dxc.community.exception.BusinessException;
import com.dxc.community.pojo.QuestionDomain;
import com.dxc.community.service.questions.QuestionsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * description: QuestionsServiceImpl <br>
 * date: 2020/3/13 14:13 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Service
public class QuestionsServiceImpl implements QuestionsService {

    @Autowired
    private QuestionsDao questionsDao;

    @Override
    public ResultInfo addQuestion(QuestionDomain questionDomain) {
        if (null == questionDomain)
            return ResultInfo.fail(ErrorConstant.Common.INVALID_PARAM);
        if (StringUtils.isBlank(questionDomain.getTitle()))
            return ResultInfo.fail(ErrorConstant.Question.TITLE_IS_EMPTY);
        if (StringUtils.isBlank(questionDomain.getDescription()))
            return ResultInfo.fail(ErrorConstant.Question.DESCRIPTION_IS_EMPTY);
        if (StringUtils.isBlank(questionDomain.getTags()))
            return ResultInfo.fail(ErrorConstant.Question.TAGS_IS_EMPTY);
        if (questionDomain.getTitle().length() > WebConst.MAX_TITLE_COUNT)
            return ResultInfo.fail(ErrorConstant.Question.MAX_TITLE);
        if (null == questionDomain.getCreator())
            return ResultInfo.fail(ErrorConstant.Question.CREATOR_IS_EMPTY);

        try {
            this.questionsDao.addQuestion(questionDomain);
            return ResultInfo.success();
        } catch (Exception ex) {
            return ResultInfo.fail(ex.getMessage());
        }


    }

    @Override
    public void deleteQuestion(Integer qid) {
        if (null == qid)
            throw new BusinessException(ErrorConstant.Common.PARAM_IS_EMPTY);

        this.questionsDao.deleteQuestion(qid);
    }

    @Override
    public PageInfo<QuestionDto> getList(QuestionDomain questionDomain, Integer pageSize, Integer pageNo) {

        if (null == questionDomain)
            throw new BusinessException(ErrorConstant.Common.PARAM_IS_EMPTY);

        PageHelper.startPage(pageNo, pageSize);

        return new PageInfo<QuestionDto>(this.questionsDao.getList(questionDomain));

    }

    @Override
    public QuestionDto getById(Integer qid) {
        if (null == qid)
            throw new BusinessException(ErrorConstant.Common.PARAM_IS_EMPTY);

        return this.questionsDao.getById(qid);
    }

    @Override
    public ResultInfo editQuestion(QuestionDomain questionDomain) {
        if (null == questionDomain)
            return ResultInfo.fail(ErrorConstant.Common.INVALID_PARAM);
        if (null == questionDomain.getQid())
            return ResultInfo.fail(ErrorConstant.Question.QID_IS_EMPTY);
        this.questionsDao.editQuestion(questionDomain);
        return ResultInfo.success();
    }

    @Override
    public void hitLikeCount(Integer qid) {
        if (null == qid)
            throw new BusinessException(ErrorConstant.Common.PARAM_IS_EMPTY);
        this.questionsDao.hitLikeCount(qid);
    }

    @Override
    public void hitViewCount(Integer qid) {
        if (null == qid)
            throw new BusinessException(ErrorConstant.Common.PARAM_IS_EMPTY);
        this.questionsDao.hitViewCount(qid);
    }
}
