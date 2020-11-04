package com.kp.dao;

import com.kp.pojo.User;

/**
 * UserDao有哪些方法，石油具体的业务逻辑决定的
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息，用于确认用户名是否可用
     * @param name 用户名
     * @return 返回null说明用户名不存在，可用
     */
    public User queryUserByName(String name);

    /**
     * 保存用户信息
     * @param user 要保存的用户信息
     */
    public void savaUser(User user);

    /**
     * 根据哟用户名密码查询用户
     * @param name 用户可名
     * @param password 密码
     * @return 返回null说明，用户名或者密码错误
     */
    public User queryUserByNameAndPassword(String name, String password);
}
