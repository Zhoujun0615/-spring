package com.how2java.test;

import com.how2java.pojo.Product;
import com.how2java.service.ProductService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:Sun
 * @date:2019/6/6 21:35
 */
public class TestSpring {
    /**
     * 测试spring的反转控制和依赖注入
     */
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"});
//        Category c = (Category) context.getBean("c");
//        System.out.println(c.getName());
        Product p = (Product) context.getBean("p");
        System.out.println(p.getName());
        System.out.println(p.getCategory().getName());

    }

    /** 测试Spring的切面编程
     * 测试日志切面是否织入业务类ProductService
     */
    @Test
    public void test1() {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"applicationContext.xml"});
//        Category c = (Category) context.getBean("c");
//        System.out.println(c.getName());
        ProductService ps = (ProductService) context.getBean("s");
        ps.doSomeService();

    }
}
