package com.numberone.quartz.util;

import java.lang.reflect.Method;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ReflectionUtils;
import com.numberone.common.utils.StringUtils;
import com.numberone.common.utils.spring.SpringUtils;

/**
 * 执行定时任务
 * 
 * @author guohui
 *
 */
public class ScheduleRunnable implements Runnable
{
    private static final Logger log = LoggerFactory.getLogger(ScheduleRunnable.class);

    private Object target;
    private Method method;
    private String params;

    public ScheduleRunnable(String beanName, String methodName, String params)
            throws NoSuchMethodException, SecurityException
    {
        this.target = SpringUtils.getBean(beanName);
        this.params = params;

        if (StringUtils.isNotEmpty(params))
        {
            this.method = target.getClass().getDeclaredMethod(methodName, String.class);
        }
        else
        {
            this.method = target.getClass().getDeclaredMethod(methodName);
        }
    }

    @Override
    public void run()
    {
        try
        {
            ReflectionUtils.makeAccessible(method);
            if (StringUtils.isNotEmpty(params))
            {
                method.invoke(target, params);
            }
            else
            {
                method.invoke(target);
            }
        }
        catch (Exception e)
        {
            log.error("执行定时任务  - ：", e);
        }
    }
}
