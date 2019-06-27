package com.how2java.jdbc;

/**
 * @author:Administrator
 * @date:2019/6/10 18:32
 */
public class TransactionAdd {

    private JdbcUserDao userDao;

    public void setUserDao(JdbcUserDao userDao) {
        this.userDao = userDao;
    }

    public void addTransaction(User user) {
        userDao.add(user);
        //中断操作
//        int a = 5 / 0;
        user.setName("cat");
        userDao.add(user);
    }
}
