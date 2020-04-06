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

