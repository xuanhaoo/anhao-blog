package com.blog.service;

import com.blog.model.Category;

import java.util.List;

/**
 * @author liangxuanhao
 * @date 2018年03月24日  16:24
 */
public interface CategoryService{


    /**
     * 查找出所有的类别,并对给类别进行计数
     * @return
     */
    List<Category> queryListAndCount();

    /**
     * 新增类别
     * @param category
     */
    void saveCate(Category category);

    /**
     * 更新
     * @param category
     */
    void updateCate(Category category);

    /**
     * 根据id查询类别信息
     * @param id
     */
    Category queryById(Integer id);

    /**
     * 删除
     * @param id
     */
    void deleteCate(Integer id);
}
