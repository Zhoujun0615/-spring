package com.how2java.aspect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**自定义工厂，内部编写方法来手动模拟spring将切面和目标类整合的过程
 * @author:Administrator
 * @date:2019/6/8 20:22
 */
public class MyBeanFactory {

    public static Service createService() {
        // 1、目标类
        final Service userService = new UserService();
        // 2、切面类
        final Myaspect myaspect = new Myaspect();
        /**
         * 3、生成整合了目标类和切面类的动态代理类
         * Proxy.newProxyInstance()的三个参数的意义
         * 参数1：loader, 类加载器，一般用目标类.getClass().getClassLoader();
         *
         * 参数2：Class[] interfaces 代理类需要实现的所有接口
         *
         * 参数3：InvocationHandler， 处理类，是接口，必须要用实现类，
         *        一般用匿名内部类的方法实现
         *        invoke()方法中的三个参数
         *        1.Object proxy : 代理对象
         *        2.Mehtod method: 代理对象当前执行的方法（通过反射得到）
         *          执行方法名：method.getName();
         *          执行方法：method.invoke(目标对象，实际参数）
         *
         *        3.Object[] args：方法实际参数
         */
        Service proxyService = (Service) Proxy.newProxyInstance(
                userService.getClass().getClassLoader(),
                userService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // 前执行
                        myaspect.before();
                        // 执行目标类的方法
                        method.invoke(userService, args);
                        // 后执行
                        myaspect.after();
                        return null;
                    }
                }
        );
        return proxyService;

    }
}
