package com.dxc.community.service.notification;

import com.dxc.community.dto.NotificationDto;
import com.dxc.community.pojo.NotificationDomain;
import com.github.pagehelper.PageInfo;

/**
 * description: NotificationService <br>
 * date: 2020/4/2 16:13 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
public interface NotificationService {

    void insert(NotificationDomain notificationDomain);

    void modifyStatus(Long nid);

    NotificationDomain getSelect(NotificationDomain notificationDomain);

    PageInfo<NotificationDto> getList(NotificationDomain notificationDomain, int pageSize, int pageNo);

}
