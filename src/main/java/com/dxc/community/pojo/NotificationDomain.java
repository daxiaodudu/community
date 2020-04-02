package com.dxc.community.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: NotificationDomain <br>
 * date: 2020/4/2 14:59 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NotificationDomain {
    private Long nid;
    private Integer notifier;
    private Integer receiver;
    private Long outerId;
    private Integer type;
    private Long gmt_create;
    private Integer status;
}
