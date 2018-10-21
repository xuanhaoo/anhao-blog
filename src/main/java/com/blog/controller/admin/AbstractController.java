package com.blog.controller.admin;

import com.blog.common.constant.Base;
import com.blog.model.User;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月9日 下午9:42:26
 */
public abstract class AbstractController {
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected User getUser() {
//		System.out.println(SecurityUtils.getSubject().getSession().getId());
		return (User) SecurityUtils.getSubject().getSession().getAttribute(Base.CURRENT_USER);
	}

	protected Long getUserId() {
		return getUser().getId();
	}
}
