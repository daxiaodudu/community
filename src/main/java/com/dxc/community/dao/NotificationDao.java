package com.dxc.community.dao;

import com.dxc.community.dto.NotificationDto;
import com.dxc.community.pojo.NotificationDomain;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * description: NotificationDao <br>
 * date: 2020/4/2 14:58 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Mapper
public interface NotificationDao {

    int insert(NotificationDomain notification);

    // 修改状态
    int modifyStatus(@Param("nid") Long nid);

    NotificationDomain getSelect(NotificationDomain notificationDomain);

    List<NotificationDto> getList(NotificationDomain notificationDomain);


}
