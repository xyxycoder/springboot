package com.xiny.mq;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.jms.Queue;



@Component
public class DataSender {

    @Autowired
    private JmsTemplate jmsTemplate;
    @Autowired
    private Queue dataQueue;

    public void sendDataMessage (String message) {
        jmsTemplate.convertAndSend(dataQueue, message);
    }


}
