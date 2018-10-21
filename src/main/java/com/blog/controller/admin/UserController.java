package com.blog.controller.admin;

import com.blog.common.constant.ResultCode;
import com.blog.common.utils.PageUtils;
import com.blog.common.utils.PasswordHelper;
import com.blog.common.utils.Query;
import com.blog.common.utils.Result;
import com.blog.model.User;
import com.blog.service.UserService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.blog.common.constant.ResultCode.PARAM_IS_INVALID;

/**
 * @author liangxuanhao
 * @date 2018年03月19日  20:43
 */
@RestController
@RequestMapping("sys/user")
public class UserController extends AbstractController{


    @Autowired
    private UserService userService;


    /**
     * 获取当前的登录的用户的信息
     * @return
     */
    @RequestMapping("/info")
    public Result info() {
        Map<String, Object> map = new HashMap<>();
        map.put("user", getUser());
        return Result.success(map);
    }


    /**
     * 获取所有的用户的信息列表
     * @param params
     * @return
     */
    @GetMapping("/list")
    public Result UserList(@RequestParam Map<String, Object> params) {


        Query query  = new Query(params);
        List<User> userList = userService.queryList(query);
        int total = userService.queryTotal(query);

        PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
        //List<User> list = userService.queryList(params);
        return Result.success(pageUtil);
    }

    /**
     * 根据逻辑id获取用户信息
     * @param id 逻辑id
     * @return
     */
    @RequestMapping("/userInfo")
    public Result queryById(@RequestParam Integer id) {

        User user = userService.queryObject(id);
        return Result.success(user);
    }

    /**
     * 新增用户
     * @param user
     * @return
     */
    @PostMapping("/save")
    public Result save(@RequestBody User user) {

        userService.save(user);

        return Result.success("添加成功！");

    }

    /**
     * 修改密码
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @PostMapping("/updatePs")
    public Result updatePs(@RequestParam String oldPassword, @RequestParam String newPassword) {

        if (StringUtils.isBlank(oldPassword) || StringUtils.isBlank(newPassword)) {
            return Result.error(ResultCode.ERROR,"请确认信息输入完整");
        }

        if (newPassword.length() < 6 || newPassword.length() > 14) {
            return Result.error(ResultCode.ERROR,"请输入6-14位密码");
        }
        User user = getUser();
        if(!user.getPassword().equals(PasswordHelper.generatePs(user, oldPassword))) {
            return Result.error(ResultCode.ERROR,"原密码错误");
        }
        user.setPassword(newPassword);
        userService.updatePassword(user);
        return Result.success("修改成功！");
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PostMapping("/update")
    public Result update(@RequestBody User user) {
        userService.update(user);
        return Result.success("更新成功！");

    }

    /**
     * 删除用户或者批量删除用户
     * @param ids
     * @return
     */
    @RequestMapping("/delete")
    public Result deleteBatch(@RequestBody Integer[] ids) {
        //当前用户
        if(ArrayUtils.contains(ids, getUserId())) {
            return Result.error(PARAM_IS_INVALID,"不能删除当前用户！");
        }
        userService.deleteUser(ids);
        return Result.success();

    }
}
