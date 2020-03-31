package com.dxc.community.pojo;

public class Tags {
    private Long tid;

    private String tagname;

    public Tags(Long tid, String tagname) {
        this.tid = tid;
        this.tagname = tagname;
    }

    public Tags() {
        super();
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public String getTagname() {
        return tagname;
    }

    public void setTagname(String tagname) {
        this.tagname = tagname == null ? null : tagname.trim();
    }
}