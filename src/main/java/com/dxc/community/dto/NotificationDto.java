package com.dxc.community.dto;

/**
 * description: NotificationDto <br>
 * date: 2020/4/2 15:01 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
public class NotificationDto {

    private Long nid;
    //    发送人id
    private Integer notifier;
    private String notifierName;
    //    接收人id
    private Integer receiver;
    private String outerId;
    //通知的回复标题或者问题标题
    private String outerTitle;
    //通知类型:1,问题回复 2.评论回复
    private Integer type;
    private Long gmt_create;
}
