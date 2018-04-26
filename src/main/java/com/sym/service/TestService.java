package com.sym.service;

import org.springframework.stereotype.Service;

/**
 * @Package: com.sym.service
 * @fileName: TestService
 * @Description:
 * @Author Suyiming3333@gmail.com
 * @Created in 14:30 2018/3/31 0031
 */

@Service
public class TestService {

    public void add(){
        System.out.println("TestService add()");
    }

    public boolean delete(){
        System.out.println("TestService delete()");
        return true;
    }

    public void edit(){
        System.out.println("TestService edit()");
        int i = 5/0;
    }

}
