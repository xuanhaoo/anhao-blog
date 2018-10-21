package com.blog.model;

import com.blog.common.model.baseModel;

/**
 * 文章类别实体类
 * @author liangxuanhao
 * @date 2018年03月24日  16:16
 */
public class Category extends baseModel<Long> {


    private static final long serialVersionUID = 1L;


    /**
     * 图片
     */
    private String avatar;

    /**
     * 类别名称
     */
    private String categoryName;

    /**
     * 简述
     */

    private String description;

    /**
     * 统计文章数量
     */
    private int counts;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }
}
