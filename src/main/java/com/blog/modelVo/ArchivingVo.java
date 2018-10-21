package com.blog.modelVo;

import com.blog.model.Article;

import java.util.List;

/**
 * 归档类
 * @author liangxuanhao
 * @date 2018年04月12日  19:03
 */
public class ArchivingVo {

   private int artYear;

   private List<Article> articles;

    public int getArtYear() {
        return artYear;
    }

    public void setArtYear(int artYear) {
        this.artYear = artYear;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
}
