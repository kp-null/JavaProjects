package com.kp.test;

import com.kp.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;

public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils(){
        Connection connection = JdbcUtils.getConnection();
        System.out.println(connection);
        //一定要关闭连接
        JdbcUtils.closeConnection(connection);
    }
}
