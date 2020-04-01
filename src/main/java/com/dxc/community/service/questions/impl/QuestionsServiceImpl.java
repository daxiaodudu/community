package com.dxc.community.service.questions.impl;


import com.dxc.community.constant.ErrorConstant;
import com.dxc.community.constant.WebConst;
import com.dxc.community.dao.*;
import com.dxc.community.dto.QuestionDto;
import com.dxc.community.dto.ResultInfo;
import com.dxc.community.exception.BusinessException;
import com.dxc.community.pojo.*;
import com.dxc.community.service.questions.QuestionsService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


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

    @Autowired
    private TagsMapper tagsMapper;
    @Autowired
    private TagsExtMapper tagsExtMapper;

    @Autowired
    private TagShipsMapper tagShipsMapper;

    @Override
    public ResultInfo addQuestion(QuestionDomain questionDomain) {
        ResultInfo resultInfo = checkModel(questionDomain);
        if (!resultInfo.isSuccess()) {
            return resultInfo;
        }

        try {

            //插入tags
            String[] split = questionDomain.getTags().split(",");
//            list = Arrays.stream(split).map(x -> {
//                Tags tags = new Tags();
//                tags.setTagname(x);
//                return tags;
//            }).collect(Collectors.toList());
            List<String> list = Arrays.stream(split).filter(x ->
                    StringUtils.isBlank(x.trim()) == false
            ).map(x -> x.trim()).distinct().collect(Collectors.toList());


            this.tagsExtMapper.insertBatch(list);

            TagsExample example = new TagsExample();
            example.createCriteria().andTagnameIn(list);

            List<Tags> tags = this.tagsMapper.selectByExample(example);
            this.questionsDao.addQuestion(questionDomain);
            ArrayList<TagShips> tagShips = new ArrayList<>();
            tags.forEach(x -> {
                TagShips ships = new TagShips();
                ships.setQid(questionDomain.getQid());
                ships.setTid(x.getTid());
                tagShips.add(ships);
            });
            this.tagShipsMapper.InsertBatch(tagShips);

            return ResultInfo.success();
        } catch (
                Exception ex) {
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
    public List<QuestionDto> getRelatedListById(Integer qid) {
        return this.questionsDao.getRelatedListById(qid);
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


    private ResultInfo checkModel(QuestionDomain questionDomain) {
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
        return ResultInfo.success();
    }

}
