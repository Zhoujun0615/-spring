package com.how2java.jdbc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:Administrator
 * @date:2019/6/10 16:24
 */
public class TestJdbcTemplate {
    /**
     * 使用传统的jdbcTemplate来实现数据库存取
     * 1.配置数据源dataSource,通常用dbcp数据源连接池作为数据源
     * 2.配置jdbcTemplate模板，并将dataSource注入
     * 3.配置Dao实现类，并将jdbcTemplate注入
     */
    @Test
    public void add() {
        User user = new User();
        user.setName("jay");
        user.setPassword("123");
        String xmlPath = "applicationContext.xml";
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext(xmlPath);
        JdbcUserDao userDao = (JdbcUserDao) applicationContext.getBean("jdbcUserDao");
        userDao.add(user);
    }

    @Test
    public void add3() {
        String xmlPath = "applicationContext.xml";
        ApplicationContext applicationContext =new ClassPathXmlApplicationContext(xmlPath);
        TransactionAdd transactionAdd = (TransactionAdd) applicationContext.getBean("transactionAdd");
        User user = new User();
        user.setName("tom");
        user.setPassword("aaa123456");
        transactionAdd.addTransaction(user);
    }
}
