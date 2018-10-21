package com.blog.dao;

import com.blog.model.Article;
import com.blog.model.ArticleBody;
import com.blog.modelVo.ArchivingVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * 文章
 * @author liangxuanhao
 * @date 2018年03月30日  15:25
 */
@Mapper
public interface ArticleDao extends BaseDao<Article>{

    /**
     * 插入文章主体内容
     * @param articleBody
     * @return 生成的主键id
     */
    void insertArticleBody(ArticleBody articleBody);

    /**
     * 保存文章
     * @param article
     * @return
     */
    void saveArticle(Article article);

    /**
     * 保存标签
     * @param articleId
     * @param tagsList
     */
    void saveTags(@Param("articleId") long articleId, @Param("tagsList") List<Integer> tagsList);

    /**
     * 更新文章主体内容
     * @param articleBody
     */
    void updateArticleBody(ArticleBody articleBody);

    /**
     * 更新文章
     * @param article
     */
    void updateArticle(Article article);


//    void updateTags(@Param("articleId") long articleId, @Param("tagsList") List<Integer> tagsList);

    /**
     * 删除标签（主要是在编辑更新文章的时候进行删除操作）
     * @param
     */
    void deleteTags(Long articleId);

    /**
     * 删除文章的主体信息
     * @param articleId
     */
    void deleteArticleBody(Long articleId);

    /**
     * 删除文章
     * @param articleId
     */
    void deleteArticle(Long articleId);


    /**
     * 查询文章文章列表（front）
     * @return
     */
    List<Article> frontQueryList(Map<String, Object> map);


    /**
     * 查询文章总数（front）
     * @param map
     * @return
     */
    int frontQueryTotal(Map<String, Object> map);


    /**
     * 文章归档查询
     * @return
     */
    List<ArchivingVo> archivingFind();




}
