package com.blog.controller.admin;

import com.blog.common.utils.PageUtils;
import com.blog.common.utils.QiniuUtil;
import com.blog.common.utils.Query;
import com.blog.common.utils.Result;
import com.blog.model.Article;
import com.blog.model.Tags;
import com.blog.modelVo.ArchivingVo;
import com.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author liangxuanhao
 * @date 2018年03月30日  16:12
 */
@RestController
@RequestMapping("/article")
public class ArticleController extends AbstractController{

    @Autowired
    private ArticleService articleService;

    @Autowired
    private QiniuUtil qiniuUtil;


    /**
     *查询当前所有的文章列表（back）
     * @return
     */
    @GetMapping("/sys/list")
    public Result query(@RequestParam Map<String, Object> params) {

        Query query = new Query(params);
        List<Article> list = articleService.queryList(query);
        int total = articleService.queryTotal();
        PageUtils pageUtils = new PageUtils(list, total,query.getLimit(),query.getPage());
        return Result.success(pageUtils);


    }

    /**
     * 查询已发布的文章列表（front）
     * @param params
     * @return
     */
    @GetMapping("/list")
    public Result indexQuery(@RequestParam Map<String, Object> params) {
        Query query = new Query(params);
        List<Article> list = articleService.frontQueryList(params);
        int total = articleService.frontQueryTotal(params);
        PageUtils pageUtils = new PageUtils(list, total,query.getLimit(),query.getPage());
        return Result.success(pageUtils);
    }

    /**
     * 根据id查询指定文章
     * @param id
     * @return
     */
    @GetMapping("/query/{id}")
    public Result queryObject(@PathVariable Integer id) {


        Article article = articleService.queryObject(id);

        return Result.success(article);
    }

    /**
     *查找标签 (根据当前文章id)
     * @return
     */
    @GetMapping("/queryTag/{id}")
    public Result queryTags(@PathVariable Integer id) {

        List<Tags> list = articleService.queryByArticle(id);
        return Result.success(list);
    }

    /**
     * 新增文章
     * @param article
     * @return
     */
    @PostMapping("/sys/save")
    public Result save(@RequestBody Article article) {


        //article.setAuthorId(getUserId());
        article.setAuthorId((long)1);
        articleService.save(article);

        return Result.success();
    }

    /**
     * 更新文章
     * @param article
     * @return
     */
    @PostMapping("/sys/update")
    public Result update(@RequestBody Article article) {

//        article.setAuthorId();
        articleService.update(article);

        return Result.success();
    }


    /**
     * 删除文章
     * @param id
     * @return
     */
    @RequestMapping("/sys/delete")
    public Result delete(@RequestParam Integer id) {

        articleService.delete(id);

        return Result.success();
    }


    /**
     * 文章的归档请求
     * @return
     */
    @GetMapping("/archiving")
    public Result archiving() {

        List<ArchivingVo> list = articleService.archivingFind();
        return Result.success(list);
    }

    /**
     * 上传文章图片至七牛
     * @param multipartFile
     * @return
     * @throws IOException
     */
    @RequestMapping("/articleUploadImg")
    public Result uploadImgQiniu(@RequestParam("image")MultipartFile multipartFile) throws IOException {
        FileInputStream inputStream = (FileInputStream) multipartFile.getInputStream();
        String path = qiniuUtil.uploadImg(inputStream, "article" + UUID.randomUUID().toString());
        return Result.success("http://"+path);
    }

}
