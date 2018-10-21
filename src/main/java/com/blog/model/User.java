package com.blog.model;

import com.blog.common.model.baseModel;
import java.util.Date;

/**
 * 系统用户
 * 
 * @author liangxuanhao
 *
 * 2018年3月18日
 *
 */
public class User extends baseModel<Long> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	

	private String account;
	
	/**
     * 使用md5(username + original password + salt)加密存储
     */
    private String password;
    
    /**
     * 头像
     */
    private String avatar;
    

	private String email;  // 邮箱

    private String nickname;

    private String mobilePhoneNumber;
    

    /**
     * 加密密码时使用的种子
     */
    private String salt;
    

    /**
     * 创建时间
     */
    private Date createDate;
    
    
    /**
     * 最后一次登录时间
     */
	private Date lastLogin;

    /**
     * 系统用户的状态
     */
    private UserStatus status = UserStatus.normal;

    /**
     * 是否是管理员
     */
    private Boolean admin = false;


	private String roles;



    /**
     * 逻辑删除flag
     */
    private Boolean deleted = Boolean.FALSE;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [account=" + account + ", password=" + password + ", avatar=" + avatar + ", email=" + email
				+ ", nickname=" + nickname + ", mobilePhoneNumber=" + mobilePhoneNumber + ", salt=" + salt
				+ ", createDate=" + createDate + ", lastLogin=" + lastLogin + ", status=" + status + ", admin=" + admin
				+ ", deleted=" + deleted + "]";
	}

}
