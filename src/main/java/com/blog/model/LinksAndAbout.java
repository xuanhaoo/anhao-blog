package com.blog.model;

/**
 * @author liangxuanhao
 * @date 2018年04月14日  15:44
 */
public class LinksAndAbout {

    private Long id;

    /**
     * 报告类型(各类型只能同时存在一条记录)
     * 1：links页
     * 2：about页
     * :)偷了个懒...
     */
    private int type;

    private String content;

    private String contentHtml;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

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
