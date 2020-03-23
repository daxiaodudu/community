package com.dxc.community.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * description: CommentsDto <br>
 * date: 2020/3/23 10:16 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommentsDto {
    private Long parent_id;
    private Integer type;
    private String content;
    private Integer creator;
}
