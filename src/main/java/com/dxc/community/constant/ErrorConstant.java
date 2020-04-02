package com.dxc.community.constant;

/**
 * description: ErrorConstant <br>
 * date: 2020/3/12 13:57 <br>
 * author: duxuecheng <br>
 * version: 1.0 <br>
 */
public interface ErrorConstant {

    interface EXCEPTION {
        static final String COMM_MSG = "系统发现异常";
    }

    interface Common {
        static final String LOGIN_IS_EMPTY = "获取用户失败";
        static final String PARAM_IS_EMPTY = "参数为空";
        static final String INVALID_PARAM = "无效的参数";
        static final String CAN_NOT_FIND_PARAM_TO_CONTIUNE = "找不到参数继续运行";
        static final String ID_IS_EMPTY = "主键不能为空";
        static final String EMAIL_IS_ERROR = "请输入正确的邮箱格式";

    }

    interface Question {
        static final String QUESTION_IS_NOT_EXIST = "问题不存在";
        static final String QID_IS_EMPTY = "主键不能为空";
        static final String TITLE_IS_EMPTY = "标题不能为空";
        static final String DESCRIPTION_IS_EMPTY = "描述不能为空";
        static final String TAGS_IS_EMPTY = "标签不能为空";
        static final String CREATOR_IS_EMPTY = "请重新登录";
        static final String MAX_TITLE = "标题字数不能大于" + WebConst.MAX_TITLE_COUNT;

    }

    interface QCOMMENTS {
        static final String FATHER_IS_INVALID = "主评论不存在或已经删除";
        static final String PARENT_ID_IS_EMPTY = "父级不能为空";
        static final String Content_IS_EMPTY = "评论内容不能为空";
        static final String TYPE_IS_EMPTY = "TYPE 不能为空";
    }



}
