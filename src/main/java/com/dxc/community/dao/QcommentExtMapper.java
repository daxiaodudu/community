package com.dxc.community.dao;

import org.apache.ibatis.annotations.Mapper;

/**
 * description: QcommentExtMapper <br>
 * date: 2020/3/28 23:42 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Mapper
public interface QcommentExtMapper {

    int modifyLike(Long cid);

    int hitReplyCount(Long cid);

}
