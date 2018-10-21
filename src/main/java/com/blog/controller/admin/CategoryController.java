package com.blog.controller.admin;

import com.blog.common.utils.QiniuUtil;
import com.blog.common.utils.Result;
import com.blog.model.Category;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author liangxuanhao
 * @date 2018年03月24日  17:14
 */
@RestController
@RequestMapping("/cate")
public class CategoryController extends AbstractController{



    @Autowired
    private CategoryService categoryService;


    @Autowired
    private QiniuUtil qiniuUtil;

    /**
     * 查询类别列表并统计各类别的文章数量
     * @return
     */
    @RequestMapping("/query")
    public Result query() {

        List list = categoryService.queryListAndCount();
        return Result.success(list);
    }

    /**
     * 新增类别信息
     * @param category
     * @return
     */
    @PostMapping("/sys/save")
    public Result save(@RequestBody Category category) {

        categoryService.saveCate(category);
        return Result.success();
    }

    /**
     * 更新类别信息
     * @param category
     * @return
     */
    @PostMapping("/sys/update")
    public Result update(@RequestBody Category category) {
        //System.out.println("111"+category.getAvatar().equals(null));
        categoryService.updateCate(category);

        return Result.success();
    }

    /**
     * 查询单个类别的信息
     * @param id
     * @return
     */
    @RequestMapping("/queryObject")
    public Result queryObject(@RequestParam Integer id) {
        Category c = categoryService.queryById(id);

        return Result.success(c);
    }

    /**
     * 删除类别
     * @param id
     * @return
     */
    @RequestMapping("sys/delete")
    public Result delete(@RequestParam Integer id) {
        categoryService.deleteCate(id);

        return Result.success();

    }


    @RequestMapping("/uploadImg")
    public Result uploadImgQiniu(@RequestParam("file")MultipartFile multipartFile) throws IOException {
        FileInputStream inputStream = (FileInputStream) multipartFile.getInputStream();
        String path = qiniuUtil.uploadImg(inputStream, "blog" + UUID.randomUUID().toString());
        return Result.success(path);
    }
}
