package com.kp.service;

import com.kp.pojo.User;

/**
 * 业务层，一个业务对应一个方法
 * 登录是一个业务
 * 注册是一个业务
 * 检查用户名存在也是一个业务
 */
public interface UserService {
    /**
     * 注册业务
     * @param user
     */
    public void registUser(User user);

    /**
     * 登录
     * @param user
     * @return
     */
    public User login(User user);

    /**
     * 检查用户名是否存在
     * @param name
     * @return 返回true，用户名已存在，不可用
     */
    public boolean existsUserName(String name);
}
