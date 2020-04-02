package com.dxc.community.service.notification.impl;

import com.dxc.community.constant.ErrorConstant;
import com.dxc.community.dao.NotificationDao;
import com.dxc.community.dto.NotificationDto;
import com.dxc.community.exception.BusinessException;
import com.dxc.community.pojo.NotificationDomain;
import com.dxc.community.service.notification.NotificationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * description: NotificationServiceImpl <br>
 * date: 2020/4/2 16:13 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationDao notificationDao;

    @Override
    public void insert(NotificationDomain notificationDomain) {
        if (null == notificationDomain) {
            throw new BusinessException(ErrorConstant.Common.PARAM_IS_EMPTY);
        }
        this.notificationDao.insert(notificationDomain);
    }

    @Override
    public void modifyStatus(Long nid) {
        this.notificationDao.modifyStatus(nid);
    }

    @Override
    public NotificationDomain getSelect(NotificationDomain notificationDomain) {
        return this.notificationDao.getSelect(notificationDomain);
    }

    @Override
    public PageInfo<NotificationDto> getList(NotificationDomain notificationDomain, int pageSize, int pageNo) {

        PageHelper.startPage(pageNo, pageSize);

        List<NotificationDto> list = this.notificationDao.getList(notificationDomain);
        return new PageInfo<>(list);

    }
}
