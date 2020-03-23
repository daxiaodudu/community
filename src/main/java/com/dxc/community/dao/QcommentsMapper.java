package com.dxc.community.dao;

import com.dxc.community.pojo.Qcomments;
import com.dxc.community.pojo.QcommentsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QcommentsMapper {
    long countByExample(QcommentsExample example);

    int deleteByExample(QcommentsExample example);

    int deleteByPrimaryKey(Long cid);

    int insert(Qcomments record);

    int insertSelective(Qcomments record);

    List<Qcomments> selectByExampleWithBLOBs(QcommentsExample example);

    List<Qcomments> selectByExample(QcommentsExample example);

    Qcomments selectByPrimaryKey(Long cid);

    int updateByExampleSelective(@Param("record") Qcomments record, @Param("example") QcommentsExample example);

    int updateByExampleWithBLOBs(@Param("record") Qcomments record, @Param("example") QcommentsExample example);

    int updateByExample(@Param("record") Qcomments record, @Param("example") QcommentsExample example);

    int updateByPrimaryKeySelective(Qcomments record);

    int updateByPrimaryKeyWithBLOBs(Qcomments record);

    int updateByPrimaryKey(Qcomments record);
}