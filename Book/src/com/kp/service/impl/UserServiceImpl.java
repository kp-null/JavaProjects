package com.kp.service.impl;

import com.kp.dao.UserDao;
import com.kp.dao.impl.UserDaoImpl;
import com.kp.pojo.User;
import com.kp.service.UserService;

public class UserServiceImpl implements UserService {

    //Service层需要和Dao层交互，创建一个Dao对象
    UserDao userDao = new UserDaoImpl();

    @Override
    public void registUser(User user) {

    }

    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public boolean existsUserName(String name) {
        return false;
    }
}
