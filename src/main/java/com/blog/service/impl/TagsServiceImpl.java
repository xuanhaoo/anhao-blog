package com.blog.service.impl;

import com.blog.dao.TagsDao;
import com.blog.model.Tags;
import com.blog.service.TagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liangxuanhao
 * @date 2018年03月24日  16:25
 */
@Service
public class TagsServiceImpl implements TagsService{

    @Autowired
    private TagsDao tagsDao;

    @Override
    public List<Tags> queryListAndCount() {
        return null;
    }

    @Override
    public List<Tags> queryList() {
        List<Tags> list = tagsDao.queryList();
        return list;
    }

    @Override
    public void saveTag(Tags tags) {
        tagsDao.save(tags);

    }

    @Override
    public void updateTag(Tags tags) {
        tagsDao.update(tags);
    }

    @Override
    public Tags queryById(Integer id) {
        Tags tag = tagsDao.queryObject(id);
        return tag;
    }

    @Override
    public void deleteTag(Integer id) {
        tagsDao.delete(id);

    }
}
