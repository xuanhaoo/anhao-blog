package com.blog.service;

import com.blog.model.Article;
import com.blog.model.Tags;
import com.blog.modelVo.ArchivingVo;

import java.util.List;
import java.util.Map;

/**
 * @author liangxuanhao
 * @date 2018年03月30日  15:27
 */
public interface ArticleService {

    /**
     * 查询列表 后台
     * @return
     */
    List<Article> queryList(Map<String, Object> map);

    /**
     * 查询文章拥有的标签
     * @param id
     * @return
     */
    List<Tags> queryByArticle(Integer id);

    Article queryObject(Integer id);


    int queryTotal();

    void save(Article article);

    void update(Article article);

    void delete(Integer id);


    /**
     * 查询文章列表（front）
     * @param map
     * @return
     */
    List<Article> frontQueryList(Map<String, Object> map);

    /**
     * 前台统计计数（可能类别不同）
     * @return
     */
    int frontQueryTotal(Map<String, Object> map);

    /**
     * 文章归档查询
     * @return
     */
    List<ArchivingVo> archivingFind();
}
