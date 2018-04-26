package com.sym.controller;

import com.sym.service.TestService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Package: com.sym.controller
 * @fileName: TestDemo
 * @Description:
 * @Author Suyiming3333@gmail.com
 * @Created in 15:22 2018/3/31 0031
 * Spring默认使用JDK动态代理，在需要代理类而不是代理接口的时候，Spring会自动切换为使用CGLIB代理
 *
 *
 *
 */
public class TestDemo {

    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        TestService ts = (TestService) ctx.getBean("testService");
        ts.add();
    }
}
