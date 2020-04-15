$(function () {
    var editor = editormd("description-edit", {
        // width  : "100%",
        height: "400px",
        path: "/js/lib/",
        imageUpload: true,
        imageFormats: ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
        imageUploadURL: "/uploadImg",
    });
});


function setTagsValue(val) {
    const oldValue = $("#tags").val();
    if (oldValue.indexOf(val) == -1) {
        if (oldValue == "" || oldValue == undefined)
            $("#tags").val(val);
        else
            $("#tags").val(oldValue + "," + val);
    }
}

function disOrHiddenTags() {
    const display = $("#tagPanel").css("display");
    if (display == undefined || display != "none") {
        $("#tagPanel").css("display", "none");
    } else {
        $("#tagPanel").css("display", "");
    }
}