package com.dxc.community.dao;

import com.dxc.community.dto.QuestionDto;
import com.dxc.community.pojo.QuestionDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description: QuestionsDao <br>
 * date: 2020/3/13 13:55 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Mapper
public interface QuestionsDao {

    int addQuestion(QuestionDomain questionDomain);

    int deleteQuestion(@Param("qid") Integer qid);

    List<QuestionDto> getList(QuestionDomain questionDomain);

    //    根据主键id 查询跟其标签相同的数据
    List<QuestionDto> getRelatedListById(@Param("qid") Integer qid);

    QuestionDomain getSelectByKey(@Param("qid") Integer qid);

    QuestionDto getById(@Param("qid") Integer qid);

    int editQuestion(QuestionDomain questionDomain);

    int hitLikeCount(@Param("qid") Integer qid);

    int hitViewCount(@Param("qid") Integer qid);

    int hitReplyCount(@Param("qid") Integer qid);
}
