package com.blog.model;

import com.blog.common.model.baseModel;

/**
 * 文章具体内容
 * @author liangxuanhao
 * @date 2018年03月29日  21:31
 */
public class ArticleBody extends baseModel<Long> {

    /**
     * 文章主体：markdown格式
     */
    private String content;

    /**
     * 文章主体：HTML格式
     */
    private String contentHtml;


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentHtml() {
        return contentHtml;
    }

    public void setContentHtml(String contentHtml) {
        this.contentHtml = contentHtml;
    }
}
