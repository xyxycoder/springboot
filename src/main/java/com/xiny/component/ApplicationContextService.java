package com.xiny.component;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by xiny on 2019/1/18.
 * description 获取sprinboot项目的ApplicationContext对象
 */
@Component
public class ApplicationContextService implements ApplicationContextAware {

    /**
     * 上下文对象实例
     */
    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext){
        setContext(applicationContext);
    }


    public static void setContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextService.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }


    /**
     * 通过name获得bean对象
     * @param name
     * @return
     */
    public static Object getBean(String name){
        return applicationContext.getBean(name);
    }


    /**
     * 通过class获取bean
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T  getBean(Class<T> clazz){
        return applicationContext.getBean(clazz);
    }


    /**
     * 通过name以及class返回指定bean
     * @param name
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> T getBean(String name,Class<T> clazz){
        return applicationContext.getBean(name,clazz);
    }
}
