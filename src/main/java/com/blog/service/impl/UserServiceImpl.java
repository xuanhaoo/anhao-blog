package com.blog.service.impl;

import com.blog.common.utils.PasswordHelper;
import com.blog.dao.UserDao;
import com.blog.model.User;
import com.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author liangxuanhao
 * @date 2018年03月18日  11:00
 */
@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryList(Map<String, Object> map) {
        return userDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userDao.queryTotal();
    }

    @Override
    public void save(User user) {
        //设置密码,以及盐
        PasswordHelper.encryptPassword(user);
        //创建日期
        user.setCreateDate(new Date());
        //暂时挖个坑，角色后续修改
        user.setRoles("admin");
        user.setAvatar("images/header_images/head.gif");
        userDao.save(user);

    }

    @Override
    public void update(User user) {

        userDao.update(user);

    }



    @Override
    public User getUserByAccount(String account) {
        User user = userDao.findByAccount(account);
        return user;
    }

    @Override
    public User queryObject(Integer id) {
        return userDao.queryObject(id);
    }

    @Override
    public void deleteUser(Integer[] ids) {

        userDao.deleteBatch(ids);

    }

    @Override
    public void updatePassword(User user) {
        PasswordHelper.encryptPassword(user);
        userDao.updatePs(user);
    }
}
