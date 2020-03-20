package com.dxc.community.pojo;

public class Contents {
    private Integer cid;

    private String title;

    private String titlepic;

    private String slug;

    private Integer created;

    private Integer modified;

    private Integer authorid;

    private String type;

    private String status;

    private String tags;

    private String categories;

    private Integer hits;

    private Integer commentsnum;

    private Boolean allowcomment;

    private Boolean allowping;

    private Boolean allowfeed;

    private String content;

    public Contents(Integer cid, String title, String titlepic, String slug, Integer created, Integer modified, Integer authorid, String type, String status, String tags, String categories, Integer hits, Integer commentsnum, Boolean allowcomment, Boolean allowping, Boolean allowfeed, String content) {
        this.cid = cid;
        this.title = title;
        this.titlepic = titlepic;
        this.slug = slug;
        this.created = created;
        this.modified = modified;
        this.authorid = authorid;
        this.type = type;
        this.status = status;
        this.tags = tags;
        this.categories = categories;
        this.hits = hits;
        this.commentsnum = commentsnum;
        this.allowcomment = allowcomment;
        this.allowping = allowping;
        this.allowfeed = allowfeed;
        this.content = content;
    }

    public Contents() {
        super();
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTitlepic() {
        return titlepic;
    }

    public void setTitlepic(String titlepic) {
        this.titlepic = titlepic == null ? null : titlepic.trim();
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug == null ? null : slug.trim();
    }

    public Integer getCreated() {
        return created;
    }

    public void setCreated(Integer created) {
        this.created = created;
    }

    public Integer getModified() {
        return modified;
    }

    public void setModified(Integer modified) {
        this.modified = modified;
    }

    public Integer getAuthorid() {
        return authorid;
    }

    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags == null ? null : tags.trim();
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories == null ? null : categories.trim();
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getCommentsnum() {
        return commentsnum;
    }

    public void setCommentsnum(Integer commentsnum) {
        this.commentsnum = commentsnum;
    }

    public Boolean getAllowcomment() {
        return allowcomment;
    }

    public void setAllowcomment(Boolean allowcomment) {
        this.allowcomment = allowcomment;
    }

    public Boolean getAllowping() {
        return allowping;
    }

    public void setAllowping(Boolean allowping) {
        this.allowping = allowping;
    }

    public Boolean getAllowfeed() {
        return allowfeed;
    }

    public void setAllowfeed(Boolean allowfeed) {
        this.allowfeed = allowfeed;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}