package com.blog.service.impl;

import com.blog.dao.ArticleDao;
import com.blog.dao.TagsDao;
import com.blog.model.Article;
import com.blog.model.ArticleBody;
import com.blog.model.Tags;
import com.blog.modelVo.ArchivingVo;
import com.blog.service.ArticleService;
import org.markdownj.MarkdownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author liangxuanhao
 * @date 2018年03月30日  16:10
 */
@Service
public class ArticleServiceImpl implements ArticleService{


    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private TagsDao tagsDao;


    @Override
    public List<Article> queryList(Map<String, Object> map) {

        return articleDao.queryList(map);
    }

    @Override
    public List<Tags> queryByArticle(Integer id) {
        return tagsDao.queryByArticle(id);
    }

    @Override
    public Article queryObject(Integer id) {
        return articleDao.queryObject(id);
    }

    @Override
    public int queryTotal() {
        return articleDao.queryTotal();
    }

    @Transactional
    @Override
    public void save(Article article) {

        ArticleBody articleBody = article.getArticleBody();
        MarkdownProcessor markdownProcessor = new MarkdownProcessor();
        String html = markdownProcessor.markdown(articleBody.getContent());
        articleBody.setContentHtml(html);

        articleDao.insertArticleBody(articleBody);
        //将返回的body_id进行设置
        article.setBodyId(articleBody.getId());
        //设置日期、评论数、浏览次数、不置顶
        article.setCreateDate(new Date());
        article.setCommentCounts(0);
        article.setViewCounts((long) 0);
        article.setWeight(0);

        article.setCategoryId(article.getCategory().getId());
        articleDao.saveArticle(article);



        //保存标签
        //List<Integer> tagsList = article.getTagsList();
        articleDao.saveTags(article.getId(), article.getTagsList());



    }

    @Transactional
    @Override
    public void update(Article article) {

        ArticleBody articleBody = article.getArticleBody();
        MarkdownProcessor markdownProcessor = new MarkdownProcessor();
        String html = markdownProcessor.markdown(articleBody.getContent());
        articleBody.setContentHtml(html);
        articleDao.updateArticleBody(articleBody);
        //更新时间
        article.setCreateDate(new Date());

        articleDao.updateArticle(article);

        //现将原来的标签关联进行删除，再进行添加
        articleDao.deleteTags(article.getId());
        articleDao.saveTags(article.getId(), article.getTagsList());


    }

    /**
     * 删除文章：将对应的文章以及文章主体和标签信息进行一并删除
     * @param id 文章id
     */
    @Transactional
    @Override
    public void delete(Integer id) {
        Article article = articleDao.queryObject(id);//获取该文章的信息
        articleDao.deleteArticleBody(article.getArticleBody().getId());//删除主体body
        articleDao.deleteArticle(Long.valueOf(id));//删除文章
        articleDao.deleteTags(Long.valueOf(id));//删除标签
    }

    @Override
    public List<Article> frontQueryList(Map<String, Object> map) {

        return articleDao.frontQueryList(map);
    }

    @Override
    public int frontQueryTotal(Map<String, Object> map) {
        return articleDao.frontQueryTotal(map);
    }

    @Override
    public List<ArchivingVo> archivingFind() {

//        List<ArchivingVo> list = articleDao.archivingFind();
//        Map<Integer, List<ArchivingVo>> map = new HashMap<>();
//        for(ArchivingVo ao : list) {
//
//            //如果为空则创建一个键值列表
//            if(map.get(ao.getArtYear()) == null) {
//                List<ArchivingVo> tempList = new ArrayList<>();
//                tempList.add(ao);
//                map.put(ao.getArtYear(), tempList);
//            }else{
//                //如果已经存在则添加到列表末尾
//                map.get(ao.getArtYear()).add(ao);
//            }
//        }
//        List<Map<Integer, List<ArchivingVo>>> result = new ArrayList<>();
//        result.add(map);
        return articleDao.archivingFind();
    }


}
