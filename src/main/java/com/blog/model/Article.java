package com.blog.model;

import com.blog.common.model.baseModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 文章实体类
 * @author liangxuanhao
 * @date 2018年03月29日  21:30
 */
public class Article extends baseModel<Long> {

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

    //作者id
    private Long authorId;

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
    private Long bodyId;

    //类别id
    private Long categoryId;

    /**
     * 是否发布
     * 0 存为草稿
     * 1 已经发布
     */
    private Integer status;



//    private User user;

    private Category category;

    private ArrayList<Integer> tagsList;

    private ArticleBody articleBody;

    private String nickname;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public Long getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
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

    public Long getBodyId() {
        return bodyId;
    }

    public void setBodyId(Long bodyId) {
        this.bodyId = bodyId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ArrayList<Integer> getTagsList() {
        return tagsList;
    }

    public void setTagsList(ArrayList<Integer> tagsList) {
        this.tagsList = tagsList;
    }

    public ArticleBody getArticleBody() {
        return articleBody;
    }

    public void setArticleBody(ArticleBody articleBody) {
        this.articleBody = articleBody;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

}
