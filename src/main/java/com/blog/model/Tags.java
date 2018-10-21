package com.blog.model;

import com.blog.common.model.baseModel;

/**
 * 标签实体类
 * @author liangxuanhao
 * @date 2018年03月24日  16:20
 */
public class Tags extends baseModel<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 标签名称

     */
    private String tagName;

    /**
     * 统计文章数量
     */
    private int count;

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
