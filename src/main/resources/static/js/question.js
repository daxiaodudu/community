$(function () {

    var testEditormdView = editormd.markdownToHTML("description-view", {
        //markdown        : markdown ,//+ "\r\n" + $("#append-test").text(),
        //htmlDecode      : true,       // 开启 HTML 标签解析，为了安全性，默认不开启
        // htmlDecode      : "style,script,iframe",  // you can filter tags decode
        //toc             : false,
        // tocm            : true,    // Using [TOCM]
        //tocContainer    : "#custom-toc-container", // 自定义 ToC 容器层
        //gfm             : false,
        //tocDropdown     : true,
        // markdownSourceCode : true, // 是否保留 Markdown 源码，即是否删除保存源码的 Textarea 标签
        //  emoji: true,
        //  taskList: true,
        //  tex: true,  // 默认不解析
        //  flowChart: true,  // 默认不解析
        //   sequenceDiagram: true,  // 默认不解析

    });
});


function post_comments() {
    const obj = {};
    obj["parent_id"] = $("#comment_qid").val();
    obj["type"] = "1";
    obj["content"] = $("#comment_content").val();
    commentsSubmit(obj, "commentsSubmit");
}

function post_secondComments(reply_id) {
    const obj = {};
    obj["parent_id"] = reply_id;
    obj["type"] = 2;
    obj["content"] = $("#second_Reply_" + reply_id).val();
    commentsSubmit(obj, "second_Reply_" + reply_id);
}

function commentsSubmit(obj, docid) {
    $.ajax({
        type: "POST",
        url: "/comments/insert",
        data: JSON.stringify(obj),
        contentType: "application/json",
        success: function (data) {
            if (data.code == "success") {
                $("#" + docid).empty();
                window.location.reload();
            } else {
                alert(data.msg);
            }
        },
        dataType: "json"
    });
}

function comments_clickLike(o) {

    const obj = {};
    obj["cid"] = o;

    $.ajax({
        type: "POST",
        url: "/comments/like",
        data: JSON.stringify(obj),
        contentType: "application/json",
        success: function (data) {
            if (data.code == "success") {
                alert("点赞成功");
            } else {
                alert(data.msg);
            }
        },
        dataType: "json"
    });
}


function showOrHidden(obj) {

    const o = "#collapseQuestion_" + obj;

    if ($(o).hasClass("in"))
        $(o).removeClass("in");
    else {
        $(o).addClass("in");
        $.ajax({
            type: "GET",
            url: "/question/secondReply/" + obj,
            // data: JSON.stringify(obj),
            // contentType: "application/json",
            success: function (htmlText) {
                $("#second_reply_" + obj).html(htmlText);
            },
            //   dataType: "json"
        });
    }
}

