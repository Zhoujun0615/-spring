package com.how2java.jdbc;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 * @author:Administrator
 * @date:2019/6/10 16:48
 */
public class JdbcUserDao2 extends JdbcDaoSupport implements UserDao {
    @Override
    public void add(User user) {
        String sql = "insert into user values(null, ?, ?)";
        getJdbcTemplate().update(sql, user.getName(), user.getPassword());
    }

}
