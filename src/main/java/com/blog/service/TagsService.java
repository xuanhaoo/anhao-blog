package com.blog.service;

import com.blog.model.Tags;

import java.util.List;

/**
 * @author liangxuanhao
 * @date 2018年03月24日  16:23
 */
public interface TagsService {

    /**
     * 查找出所有的标签,并对给标签下的文章进行计数
     * @return
     */
    List<Tags> queryListAndCount();

    List<Tags> queryList();

    /**
     * 新增标签
     * @param tags
     */
    void saveTag(Tags tags);

    /**
     * 更新
     * @param tags
     */
    void updateTag(Tags tags);

    /**
     * 根据id查询标签信息
     * @param id
     */
    Tags queryById(Integer id);

    /**
     * 删除
     * @param id
     */
    void deleteTag(Integer id);
}
