package com.blog.dao;

import com.blog.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liangxuanhao
 * @date 2018年03月19日  11:31
 */
@Mapper
public interface UserDao extends BaseDao<User> {

    /**
     * 根据账号获取用户信息
     * @param account
     * @return
     */
    User findByAccount(String account);

    /**
     * 更新密码
     * @param user
     */
    void updatePs(User user);
}
