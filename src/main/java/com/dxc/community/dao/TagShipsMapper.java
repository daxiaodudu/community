package com.dxc.community.dao;

import com.dxc.community.pojo.TagShips;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description: TagShipsMapper <br>
 * date: 2020/3/31 11:43 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Mapper
public interface TagShipsMapper {
    int InsertBatch(@Param("list") List<TagShips> list);
}
