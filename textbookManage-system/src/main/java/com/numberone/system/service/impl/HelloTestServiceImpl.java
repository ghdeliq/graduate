package com.numberone.system.service.impl;

import com.numberone.system.service.HelloTestService;
import org.springframework.stereotype.Service;

@Service
public class HelloTestServiceImpl implements HelloTestService {
    @Override
    public void test(int asd) {
        System.out.println("hello， world，我执行了。");
    }
}
