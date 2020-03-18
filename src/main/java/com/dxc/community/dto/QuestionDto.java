package com.dxc.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: QuestionDto <br>
 * date: 2020/3/14 13:47 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionDto {
    private Integer qid;
    private String title;
    private String description;
    private String tags;
    private Long gmt_create;
    private Long gmt_modify;
    private Integer creator;
    private Integer view_count;
    private Integer like_count;
    private String username;
}
