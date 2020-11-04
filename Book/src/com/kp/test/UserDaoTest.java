package com.kp.test;

import com.kp.dao.UserDao;
import com.kp.dao.impl.UserDaoImpl;
import com.kp.pojo.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();

    @Test
    public void queryUserByName() {
        User admin = userDao.queryUserByName("admina");
        System.out.println(admin);
    }

    @Test
    public void savaUser() {
        User user = new User(null, "Tom", "123123", "Tom@qq.com");
        userDao.savaUser(user);
        User user1 = userDao.queryUserByName("Tom");
        System.out.println(user1);
    }

    @Test
    public void queryUserByNameAndPassword() {
        User user = userDao.queryUserByNameAndPassword("admin", "admin");
        System.out.println(user);
    }
}