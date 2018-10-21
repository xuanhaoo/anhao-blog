package com.blog.service;

import com.blog.model.LinksAndAbout;

/**
 * 链接和about页面内容处理
 * @author liangxuanhao
 * @date 2018年04月14日  15:49
 */
public interface LinksAndAboutService {


    /**
     * 新建内容
     * @param linksAndAbout
     */
    void save(LinksAndAbout linksAndAbout);

    /**
     * 更新内容
     * @param linksAndAbout
     */
    void update(LinksAndAbout linksAndAbout);

    /**
     * 查询内容
     * @param type
     * @return
     */
    LinksAndAbout queryObject(Integer type);
}
