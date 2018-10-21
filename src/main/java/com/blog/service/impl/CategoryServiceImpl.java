package com.blog.service.impl;

import com.blog.dao.CategoryDao;
import com.blog.model.Category;
import com.blog.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangxuanhao
 * @date 2018年03月24日  16:25
 */
@Service
public class CategoryServiceImpl implements CategoryService{


    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> queryListAndCount() {
        return categoryDao.queryAndCount();
    }

    @Override
    public void saveCate(Category category) {
        //暂时设为相对路径，后改为七牛云
        //category.setAvatar("images/category/front.png");
        categoryDao.save(category);
    }

    @Override
    public void updateCate(Category category) {
        categoryDao.update(category);
    }

    @Override
    public Category queryById(Integer id) {
        return categoryDao.queryObject(id);
    }

    @Override
    public void deleteCate(Integer id) {
        categoryDao.delete(id);
    }
}
