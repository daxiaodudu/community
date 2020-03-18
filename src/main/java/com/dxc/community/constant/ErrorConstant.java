package com.dxc.community.constant;

/**
 * description: ErrorConstant <br>
 * date: 2020/3/12 13:57 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
public interface ErrorConstant {
    interface Common {
        static final String PARAM_IS_EMPTY = "参数为空";
        static final String INVALID_PARAM = "无效的参数";
        static final String CAN_NOT_FIND_PARAM_TO_CONTIUNE = "找不到参数继续运行";
        static final String ID_IS_EMPTY = "主键不能为空";
        static final String EMAIL_IS_ERROR = "请输入正确的邮箱格式";
    }

    interface Question {
        static final String TITLE_IS_EMPTY = "标题不能为空";
        static final String DESCRIPTION_IS_EMPTY = "描述不能为空";
        static final String TAGS_IS_EMPTY = "标签不能为空";
        static final String CREATOR_IS_EMPTY = "请重新登录";
        static final String MAX_TITLE = "标题字数不能大于" + WebConst.MAX_TITLE_COUNT;

    }

}
