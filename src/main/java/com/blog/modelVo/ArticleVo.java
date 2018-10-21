package com.blog.modelVo;

import java.util.Date;
import java.util.List;

/**
 * 展示文章实体类
 * @author liangxuanhao
 * @date 2018年03月30日  15:28
 */
public class ArticleVo {


    private Long id;

    //文章评论数
    private Integer commentCounts;

    //文章摘要
    private String summary;

    //标题
    private String title;

    //文章点击数（浏览次数）
    private Long viewCounts;

    /**
     * 是否置顶
     * 0 no
     * 1 yes
     */
    private Integer weight;

    //作者名称
    private String authorName;

    /**
     * 是否允许评论
     * 0 no
     * 1 yes
     */
    private Integer allowComment;

    //创建时间
    private Date createDate;

    /**
     * 文章主体关联id
     */
    private String bodyContent;

    //类别id
    private String categoryName;

    /**
     * 是否发布
     * 0 存为草稿
     * 1 已经发布
     */
    private Integer status;

    private List<String> tagsList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCommentCounts() {
        return commentCounts;
    }

    public void setCommentCounts(Integer commentCounts) {
        this.commentCounts = commentCounts;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getViewCounts() {
        return viewCounts;
    }

    public void setViewCounts(Long viewCounts) {
        this.viewCounts = viewCounts;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public Integer getAllowComment() {
        return allowComment;
    }

    public void setAllowComment(Integer allowComment) {
        this.allowComment = allowComment;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getBodyContent() {
        return bodyContent;
    }

    public void setBodyContent(String bodyContent) {
        this.bodyContent = bodyContent;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<String> getTagsList() {
        return tagsList;
    }

    public void setTagsList(List<String> tagsList) {
        this.tagsList = tagsList;
    }
}
