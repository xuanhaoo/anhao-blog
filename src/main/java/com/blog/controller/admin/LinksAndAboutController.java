package com.blog.controller.admin;

import com.blog.common.utils.Result;
import com.blog.model.LinksAndAbout;
import com.blog.service.LinksAndAboutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 链接和关于 内容管理
 * @author liangxuanhao
 * @date 2018年04月14日  15:57
 */
@RestController
@RequestMapping("/linksAbout")
public class LinksAndAboutController {


    @Autowired
    private LinksAndAboutService linksAndAboutService;

    /**
     *添加
     * @param linksAndAbout
     * @return
     */
    @PostMapping("/sys/save")
    public Result save(@RequestBody LinksAndAbout linksAndAbout){
        linksAndAboutService.save(linksAndAbout);
        return Result.success();
    }

    /**
     * 更新
     * @param linksAndAbout
     * @return
     */
    @PostMapping("/sys/update")
    public Result update(@RequestBody LinksAndAbout linksAndAbout) {
        linksAndAboutService.update(linksAndAbout);
        return Result.success();
    }

    /**
     * 查询链接管理的内容
     * @return
     */
    @GetMapping("/links")
    public Result queryLinks() {

        LinksAndAbout linksAndAbout = linksAndAboutService.queryObject(1);

        return Result.success(linksAndAbout);
    }

    /**
     * 查询关于我页面内容
     * @return
     */
    @GetMapping("/about")
    public Result queryAbout() {
        LinksAndAbout linksAndAbout = linksAndAboutService.queryObject(2);
        return Result.success(linksAndAbout);
    }


}
