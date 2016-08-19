package com.maxim.jms.listner;


import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * Created by lede on 8/19/16.
 */

@Component
public class ConsumerListener implements MessageListener {

    @Override
    public void onMessage(Message arg0){
        System.out.println("In onMessage()");
    }
}
