package com.dxc.community.service.comments.impl;

import com.dxc.community.constant.CommentTypeEnum;
import com.dxc.community.constant.ErrorConstant;
import com.dxc.community.dao.QcommentsMapper;
import com.dxc.community.dao.QuestionsDao;
import com.dxc.community.dto.CommentsDto;
import com.dxc.community.dto.QuestionDto;
import com.dxc.community.exception.BusinessException;
import com.dxc.community.pojo.Qcomments;
import com.dxc.community.pojo.QcommentsExample;
import com.dxc.community.service.comments.CommentsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;

/**
 * description: CommentsServiceImpl <br>
 * date: 2020/3/23 9:44 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Service
public class CommentsServiceImpl implements CommentsService {

    @Autowired
    private QcommentsMapper qcommentsMapper;

    @Autowired
    private QuestionsDao questionsDao;

    @Override
    public PageInfo<Qcomments> getListByParentId(Long parentId, Integer type, int pageSize, int pageNo) {
        if (null == parentId)
            throw new BusinessException(ErrorConstant.Common.PARAM_IS_EMPTY);
        PageHelper.startPage(pageNo, pageSize);

        QcommentsExample qcommentsExample = new QcommentsExample();
        qcommentsExample.createCriteria()
                .andParentIdEqualTo(parentId).andTypeEqualTo(type);

        return new PageInfo<>(this.qcommentsMapper.selectByExample(qcommentsExample));
    }

    @Override
    public void modifyComment(Qcomments qcomments) {

    }

    @Override
    public void insertComment(CommentsDto qcommentsDto) {
        if (null == qcommentsDto)
            throw new BusinessException(ErrorConstant.Common.PARAM_IS_EMPTY);
        if (null == qcommentsDto.getParent_id())
            throw new BusinessException(ErrorConstant.QCOMMENTS.PARENT_ID_IS_EMPTY);
        if (null == qcommentsDto.getType())
            throw new BusinessException(ErrorConstant.QCOMMENTS.TYPE_IS_EMPTY);
        if (StringUtils.isBlank(qcommentsDto.getContent()))
            throw new BusinessException(ErrorConstant.QCOMMENTS.Content_IS_EMPTY);


        if (qcommentsDto.getType().equals(CommentTypeEnum.COMMENT_CHILD.getType())) {
            Qcomments qcomments = this.qcommentsMapper.selectByPrimaryKey(qcommentsDto.getParent_id());
            if (null == qcomments)
                throw new BusinessException(ErrorConstant.QCOMMENTS.FATHER_IS_INVALID);
        } else {
            QuestionDto questionDto = this.questionsDao.getById(qcommentsDto.getParent_id().intValue());
            if (null == questionDto)
                throw new BusinessException(ErrorConstant.Question.QUESTION_IS_NOT_EXIST);
        }

        Qcomments qcomments = new Qcomments();
        qcomments.setParentId(qcommentsDto.getParent_id());
        qcomments.setType(qcommentsDto.getType());
        qcomments.setContent(qcommentsDto.getContent());
        qcomments.setCreator(qcommentsDto.getCreator());
        qcomments.setGmtCreate(System.currentTimeMillis());
        qcomments.setGmtModified(System.currentTimeMillis());
        qcomments.setLikeCount(0L);
        this.qcommentsMapper.insert(qcomments);
        //添加回复数
        if (qcommentsDto.getType().equals(CommentTypeEnum.COMMENT.getType())) {
            this.questionsDao.hitViewCount(qcommentsDto.getParent_id().intValue());
        }
    }

    @Override
    public void deleteComment(Integer cid) {

    }

    @Override
    public Qcomments getById(Long cid) {
        if (null == cid)
            throw new BusinessException(ErrorConstant.Common.PARAM_IS_EMPTY);
        return this.qcommentsMapper.selectByPrimaryKey(cid);
    }
}
