package com.how2java.aspect;

/** 切面类
 * @author:Administrator
 * @date:2019/6/8 20:19
 */
public class Myaspect {

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }
}
