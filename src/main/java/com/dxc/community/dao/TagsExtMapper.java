package com.dxc.community.dao;

import com.dxc.community.pojo.Tags;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description: TagsExtMapper <br>
 * date: 2020/3/31 11:29 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Mapper
public interface TagsExtMapper {

    int insertBatch(@Param("list")List<Tags> list);
}
