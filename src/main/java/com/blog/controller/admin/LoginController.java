package com.blog.controller.admin;

import com.blog.common.constant.Base;
import com.blog.common.constant.ResultCode;
import com.blog.common.utils.Result;
import com.blog.model.User;
import com.blog.oauth.OAuthSessionManager;
import com.blog.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * 后台登录
 * @author liangxuanhao
 * @date 2018年03月18日  10:21
 */
@RestController
public class LoginController extends AbstractController{

    @Autowired
    private UserService userService;


    @GetMapping("/test")
    public Result test() {

        return Result.success();
    }

    @PostMapping("/sys/login")
    public Result login(@RequestBody User user) {

        Result result = new Result();
        checkLogin(user.getAccount(), user.getPassword(), result);
        return result;
    }


    /**
     * 检查登录
     * @param account
     * @param password
     * @param r
     */
    private void checkLogin(String account, String password, Result r) {
        //安全操作，获取当前正在执行的用户
        Subject subject = SecurityUtils.getSubject();
        //构造一个空的UsernamePasswordToken封装认证尝试期间所提交的用户名和密码,生成令牌
        UsernamePasswordToken token = new UsernamePasswordToken(account, password);

        try {
            //进行认证尝试
            subject.login(token);
            User currentUser = userService.getUserByAccount(account);
            //将当前用户的信息放到session里
            subject.getSession().setAttribute(Base.CURRENT_USER, currentUser);
            r.setResultCode(ResultCode.SUCCESS);
            r.simple().put(OAuthSessionManager.OAUTH_TOKEN, subject.getSession().getId());

        } catch (UnknownAccountException e) {
            r.setResultCode(ResultCode.USER_NOT_EXIST);
        } catch (LockedAccountException e) {
            r.setResultCode(ResultCode.USER_ACCOUNT_FORBIDDEN);
        } catch (AuthenticationException e) {
            r.setResultCode(ResultCode.USER_LOGIN_ERROR);
        } catch (Exception e) {
            r.setResultCode(ResultCode.ERROR);
        }

    }


    /**
     * 退出登录
     * @return
     */
    @GetMapping("/sys/logout")
    public Result logout() {

        Result r = new Result();
        Subject subject = SecurityUtils.getSubject();
        subject.logout();

        r.setResultCode(ResultCode.SUCCESS);
        return r;

    }
}
