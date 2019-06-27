package com.how2java.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author:Administrator
 * @date:2019/6/10 16:18
 */
public class JdbcUserDao implements UserDao {
    private JdbcTemplate jdbcTemplate;

    @Override
    public void add(User user) {
        String sql = "insert into user values(null, ?, ?)";
        jdbcTemplate.update(sql, user.getName(), user.getPassword());
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
