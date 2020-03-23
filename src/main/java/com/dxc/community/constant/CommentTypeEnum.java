package com.dxc.community.constant;

/**
 * description: CommEnum <br>
 * date: 2020/3/23 14:39 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
public enum CommentTypeEnum {

    COMMENT(1), //直接评论
    COMMENT_CHILD(2);//评论的评论

    private Integer type;

    public Integer getType() {
        return this.type;
    }

    CommentTypeEnum(Integer type) {
        this.type = type;
    }
}
