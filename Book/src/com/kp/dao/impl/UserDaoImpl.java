package com.kp.dao.impl;

import com.kp.dao.UserDao;
import com.kp.pojo.User;

import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User queryUserByName(String name) {
        String sql="select id, username, password, email from t_user where username = ?";
        User user = queryForOne(User.class, sql, name);
        return user;
    }

    @Override
    public void savaUser(User user) {
        String sql = "insert into t_user(username, password, email) values (?, ?, ?)";
        update(sql, user.getUsername(), user.getPassword(), user.getEmail());


    }

    @Override
    public User queryUserByNameAndPassword(String name, String password) {
        String sql="select id, username, password, email from t_user where username = ? and password = ?";
        User user = queryForOne(User.class, sql, name, password);
        return user;
    }
}
