package com.blog.service;

import com.blog.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author liangxuanhao
 * @date 2018年03月18日  10:52
 */
public interface UserService {

    /**
     * 查询所有的用户列表
     * @param map 查询参数
     * @return
     */
    List<User> queryList(Map<String, Object> map);

    /**
     * 总数
     * @param map
     * @return
     */
    int queryTotal(Map<String, Object> map);

    /**
     * 保存用户
     * @param user
     */
    void save(User user);

    /**
     * 更新信息
     * @param user
     */
    void update(User user);

    /**
     * 根据用户账户信息获取账户
     * @param account
     * @return
     */
    User getUserByAccount(String account);

    /**
     * 根据用户id查找用户信息
     * @param id
     * @return
     */
    User queryObject(Integer id);

    /**
     * 删除用户
     */
    void deleteUser(Integer[] id);

    /**
     * 更新密码
     * @param user
     */
    void updatePassword(User user);
}
