package com.xiny.mq;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;



@Component
public class DataQueueListerner {

    private static Logger logger = LoggerFactory.getLogger(DataQueueListerner.class);


//    @JmsListener(destination = "dataQueue", concurrency = "1-3")
    public void onMessage(String msg) {
        System.out.println("收到信息："+msg);
//        Map<String, String> map = JSON.parseObject(msg, HashMap.class);




    }

}
