package com.ning.service.user;

import com.ning.pojo.User;

public interface UserService {
	/**
	 * 判断用户是否存在
	 * @param username
	 * @return
	 */
	public boolean queryUsernameIsExist(String username);
	/**
	 * 查询登录用户是否注册过
	 * @param username
	 * @param password
	 * @return
	 */
	public User queryUserForLogin(String username,String password);
	/**
	 * 用户注册
	 * @param user
	 * @return
	 */
	public User saveUser(User user);
	/**
	 * 更新用户数据
	 * @param user
	 * @return
	 */
	public User updateUserInfo(User user);
}
