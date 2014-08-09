package com.ofg.microservice.facebook

import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.core.MessageCreator
import org.springframework.stereotype.Component

import javax.jms.JMSException
import javax.jms.Message
import javax.jms.Session
import javax.jms.TextMessage

@Slf4j
@Component
@TypeChecked
class FacebookDataBroadcaster {
    
    final static String PAIR_ID = "PAIR_ID"
    
    final static String TOPIC_NAME = "facebook";

    private final JmsTemplate jmsTemplate

    @Autowired
    FacebookDataBroadcaster(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate
    }

    public void broadcast(FacebookData data, long pairId){
        jmsTemplate.send(TOPIC_NAME, new FacebookMessageCreator(data, pairId))
    }

    static class FacebookMessageCreator implements MessageCreator {

        private final FacebookData data

        private final long pairId

        FacebookMessageCreator(FacebookData data, long pairId) {
            this.pairId = pairId
            this.data = data
        }

        @Override
        Message createMessage(Session session) throws JMSException {
            // org.springframework.jms.support.converter.MappingJackson2MessageConverter
            TextMessage message = session.createTextMessage(data.toString()); // FIXME USE Jackson Mapper to get JSON
            message.setLongProperty(PAIR_ID, pairId);
            log.info("Sending for pairID {} message: {}",  pairId, data);
            return message;
        }
    }
}
