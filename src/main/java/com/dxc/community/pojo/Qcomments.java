package com.dxc.community.pojo;

public class Qcomments {
    private Long cid;

    private Long parentId;

    private Integer type;

    private Integer creator;

    private Long gmtCreate;

    private Long gmtModified;

    private Long likeCount;

    private Long replyCount;

    private String content;

    public Qcomments(Long cid, Long parentId, Integer type, Integer creator, Long gmtCreate, Long gmtModified, Long likeCount, Long replyCount, String content) {
        this.cid = cid;
        this.parentId = parentId;
        this.type = type;
        this.creator = creator;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.likeCount = likeCount;
        this.replyCount = replyCount;
        this.content = content;
    }

    public Qcomments() {
        super();
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCreator() {
        return creator;
    }

    public void setCreator(Integer creator) {
        this.creator = creator;
    }

    public Long getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Long likeCount) {
        this.likeCount = likeCount;
    }

    public Long getReplyCount() {
        return replyCount;
    }

    public void setReplyCount(Long replyCount) {
        this.replyCount = replyCount;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}