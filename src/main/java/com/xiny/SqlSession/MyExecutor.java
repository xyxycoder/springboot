package com.xiny.SqlSession;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class MyExecutor {


    private static int poolSize = Runtime.getRuntime().availableProcessors() * 2;

    private static ScheduledThreadPoolExecutor scheduledThreadPoolExecutor;

    private static ThreadPoolExecutor executor;

    private static final ThreadFactory factory = new ThreadFactoryBuilder().setNameFormat("my-task-%d").build();


    @Bean("/myExecutor")
    public ThreadPoolExecutor initExecutor() {
        return buildExecutor();
    }

    @Bean("/myScheduleExecutor")
    public ScheduledThreadPoolExecutor initScheduledExecutor() {
        return buildScheduledExecutor();
    }

    public static synchronized ThreadPoolExecutor getExecutor(){
        if(null == executor){
            return buildScheduledExecutor();
        }
        return executor;
    }

    public static synchronized ScheduledThreadPoolExecutor getScheduledThreadPoolExecutor(){
        if(null == scheduledThreadPoolExecutor){
            return buildScheduledExecutor();
        }
        return scheduledThreadPoolExecutor;
    }

    private static ScheduledThreadPoolExecutor buildScheduledExecutor() {
        scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(5, factory);
        return scheduledThreadPoolExecutor;
    }

    private static ThreadPoolExecutor buildExecutor() {
        executor = new ThreadPoolExecutor(2, poolSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(200), factory);
        return executor;
    }


}
