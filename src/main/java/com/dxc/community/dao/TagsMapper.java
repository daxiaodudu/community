package com.dxc.community.dao;

import com.dxc.community.pojo.Tags;
import com.dxc.community.pojo.TagsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface TagsMapper {
    long countByExample(TagsExample example);

    int deleteByExample(TagsExample example);

    int deleteByPrimaryKey(Long tid);

    int insert(Tags record);

    int insertSelective(Tags record);

    List<Tags> selectByExample(TagsExample example);

    Tags selectByPrimaryKey(Long tid);

    int updateByExampleSelective(@Param("record") Tags record, @Param("example") TagsExample example);

    int updateByExample(@Param("record") Tags record, @Param("example") TagsExample example);

    int updateByPrimaryKeySelective(Tags record);

    int updateByPrimaryKey(Tags record);
}