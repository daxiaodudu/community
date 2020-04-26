function click_search() {
    const searhVal = $.trim($("#txtSearch").val());
    if (searhVal == "") {
        alert("搜索内容不能为空");
        return;
    }
    window.location.href="~/home?search="+searhVal;
}