package com.dxc.community.service.comments;

import com.dxc.community.dto.CommentsDto;
import com.dxc.community.pojo.Qcomments;
import com.github.pagehelper.PageInfo;

import java.math.BigInteger;

/**
 * description: Comments <br>
 * date: 2020/3/23 9:43 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
public interface CommentsService {

    PageInfo<Qcomments> getListByParentId(Long parentId, Integer type, int pageSize, int pageNo);

    void modifyComment(Qcomments qcomments);

    void insertComment(CommentsDto qcomments);

    void deleteComment(Integer cid);

    Qcomments getById(Long cid);


    void updateLikeComment(Long cid);

}
