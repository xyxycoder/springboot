package com.xiny.mq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UcviewDataJob {
    @Autowired
    private DataSender dataSender;

//    @Scheduled(fixedRate = 1000 * 60)
    public void startDataJob() {
        System.out.println("测试发送");
        dataSender.sendDataMessage("测试");
    }

}
