package com.blog.dao;

import com.blog.model.Tags;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author liangxuanhao
 * @date 2018年03月24日  16:22
 */
@Mapper
public interface TagsDao extends BaseDao<Tags>{

    /**
     * 查询全部的标签并进行计数
     * @return
     */
    List<Tags> queryAndCount();


    List<Tags> queryByArticle(Integer id);

}
