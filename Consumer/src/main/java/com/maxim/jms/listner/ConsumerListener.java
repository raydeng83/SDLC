package com.maxim.jms.listner;


import com.maxim.jms.adapter.ConsumerAdapter;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.net.UnknownHostException;

/**
 * Created by lede on 8/19/16.
 */

@Component
public class ConsumerListener implements MessageListener {

    private static Logger logger = LogManager.getLogger(ConsumerListener.class.getName());

    @Autowired
    private JmsTemplate jmsTemplate;

    @Autowired
    private ConsumerAdapter consumerAdapter;

    @Override
    public void onMessage(Message message) {
        logger.info("In onMessage()");

        String json = null;

        if (message instanceof TextMessage) {
            try {
                json = ((TextMessage) message).getText();
                logger.info("Sending JSON to DB: " + json);
                consumerAdapter.sendToMongo(json);
            } catch (JMSException e) {
                logger.error("Message: " + json);
                jmsTemplate.convertAndSend(json);
            }catch (Exception e) {
                logger.error("Message: " + json);
                jmsTemplate.convertAndSend(json);
            }
        }
    }
}
