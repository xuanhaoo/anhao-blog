package com.blog.controller.admin;

import com.blog.common.utils.Result;
import com.blog.model.Tags;
import com.blog.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 标签
 * @author liangxuanhao
 * @date 2018年03月29日  10:55
 */
@RestController
@RequestMapping("/tags")
public class TagsController extends AbstractController{

    @Autowired
    private TagsService tagsService;


    /**
     * 查询标签列表
     * @return
     */
    @GetMapping("/query")
    public Result queryList() {

        List<Tags> list = tagsService.queryList();
        return Result.success(list);
    }


    /**
     * 根据id查询指定标签
     * @param id
     * @return
     */
    @RequestMapping("/queryObject")
    public Result queryObject(@RequestParam Integer id) {

        Tags tag = tagsService.queryById(id);

        return Result.success(tag);
    }

    /**
     * 新增
     * @param tags
     * @return
     */
    @PostMapping("/sys/save")
    public Result save(@RequestBody Tags tags) {

        tagsService.saveTag(tags);
        return Result.success();
    }

    /**
     * 更新
     * @param tags
     * @return
     */
    @PostMapping("/sys/update")
    public Result update(@RequestBody Tags tags) {
        tagsService.updateTag(tags);

        return Result.success();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping("/sys/delete")
    public Result delete(@RequestParam Integer id) {
        tagsService.deleteTag(id);

        return Result.success();
    }

}
