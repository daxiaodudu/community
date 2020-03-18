package com.dxc.community.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: QuestionDomain <br>
 * date: 2020/3/13 13:55 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuestionDomain {
    private Integer qid;
    private String title;
    private String description;
    private String tags;
    private Long gmt_create;
    private Long gmt_modify;
    private Integer creator;
    private Integer view_count;
    private Integer like_count;

}
