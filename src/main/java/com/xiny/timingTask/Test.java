package com.xiny.timingTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by xiny on 2018/12/3.
 */
@Component
@PropertySource(value = {"classpath:application-dev.properties"})
public class Test {

    @Value("${spring.datasource.druid.url}")
    private String address;

    @Autowired
    private Environment env;

//    @Scheduled(cron="0/5 * * * * ? ")
    public void system(){
        String s = env.getProperty("druid.allow.ip");
        System.out.println(s+address);
    }
}
