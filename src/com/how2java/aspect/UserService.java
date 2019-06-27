package com.how2java.aspect;

/**被代理接口的实现类
 * @author:Administrator
 * @date:2019/6/8 20:16
 */
public class UserService implements Service {
    @Override
    public void addService() {
        System.out.println("addService");
    }

    @Override
    public void updateService() {
        System.out.println("updateService");

    }

    @Override
    public void deleteService() {
        System.out.println("deleteService");
    }
}
