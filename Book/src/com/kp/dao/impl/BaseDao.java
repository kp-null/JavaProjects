package com.kp.dao.impl;

import com.kp.pojo.User;
import com.kp.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    //使用DBUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    /**
     *
     * @param sql
     * @param args
     * @return 返回-1表示update失败
     */
    public int update(String sql, Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connection, sql, args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JdbcUtils.closeConnection(connection);
        }
        return -1;
    }

    /**
     * 查询一个java bean
     * @param type 返回的对象类型
     * @param sql SQL语句
     * @param args 对应的参数值
     * @param <T> 返回类型的泛型
     * @return java bean
     */
    public<T> T queryForOne(Class<T> type, String sql, Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            T query = queryRunner.query(connection, sql, new BeanHandler<T>(type), args);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

    /**
     * 查询多个java bean
     * @param type 返回的对象类型
     * @param sql SQL语句
     * @param args SQL参数
     * @param <T> 返回值类型的泛型
     * @return 返回java bean 构成的list
     */
    public<T> List<T> queryForList(Class<T> type, String sql, Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            List<T> query = queryRunner.query(connection, sql, new BeanListHandler<T>(type), args);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }

        return null;
    }

    /**
     * 特殊查询
     * @param sql
     * @param args
     * @return
     */
    public Object querySingleValue(String sql, Object... args){
        Connection connection = JdbcUtils.getConnection();
        try {
            Object query = queryRunner.query(connection, sql, new ScalarHandler(), args);
            return query;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JdbcUtils.closeConnection(connection);
        }
        return null;
    }

}
