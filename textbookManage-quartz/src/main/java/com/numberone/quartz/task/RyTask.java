package com.numberone.quartz.task;

import com.numberone.system.service.HelloTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 定时任务调度测试
 * 
 * @author numberone
 */
@Component("ryTask")
public class RyTask
{
    @Autowired
    private HelloTestService helloTestService;
    public void ryParams(String params)
    {
        System.out.println("执行有参方法：" + params);
    }

    public void ryNoParams()
    {
        System.out.println("执行无参方法");
    }

    public void test(int asd) {
        helloTestService.test(asd);
    }
}
