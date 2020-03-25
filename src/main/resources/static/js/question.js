function post_comments() {
    var obj = {};
    obj["parent_id"] = $("#comment_qid").val();
    obj["type"] = "1";
    obj["content"] = $("#comment_content").val();

    $.ajax({
        type: "POST",
        url: "/comments/insert",
        data: JSON.stringify(obj),
        contentType: "application/json",
        success: function (data) {
            if (data.code == "success") {
                $("#comment").empty();
            } else {
                alert(data.msg);
            }
        },
        dataType: "json"
    });

    console.log(obj);
}