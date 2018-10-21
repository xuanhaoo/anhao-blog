package com.blog.dao;

import com.blog.model.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liangxuanhao
 * @date 2018年03月24日  16:26
 */
@Mapper
public interface CategoryDao extends BaseDao<Category>{

    /**
     * 查询全部的类别并进行计数
     * @return
     */
    List<Category> queryAndCount();

}
