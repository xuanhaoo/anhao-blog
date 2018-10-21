package com.blog.common.utils;


import com.blog.model.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 用户 加密工具
 *	生成随机salt
 *	md5(md5(password))
 * 
 * @author shimh
 *
 * 2018年1月23日
 *
 */
public class PasswordHelper {

    private static RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();

    private static String algorithmName = "md5";
    private static final int hashIterations = 2;

    public static void encryptPassword(User user) {

        user.setSalt(randomNumberGenerator.nextBytes().toHex());

        String newPassword = new SimpleHash(
                algorithmName,
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                hashIterations).toHex();

        user.setPassword(newPassword);
    }

    /**
     * 检查密码是否正确
     * @param user
     * @param checkedPassword
     * @return
     */
    public static String generatePs(User user, String checkedPassword) {
        String password = new SimpleHash(
                algorithmName,
                checkedPassword,
                ByteSource.Util.bytes(user.getSalt()),
                hashIterations).toHex();

        return password;
    }
    
    
}