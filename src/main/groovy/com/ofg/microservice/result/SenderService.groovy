package com.ofg.microservice.result

import com.sun.media.sound.ModelDestination
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import org.slf4j.MDC
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jms.core.JmsTemplate
import org.springframework.jms.core.MessageCreator
import org.springframework.stereotype.Service
import scala.util.parsing.combinator.testing.Str

import javax.jms.Destination
import javax.jms.JMSException
import javax.jms.Message
import javax.jms.Session
import javax.jms.TextMessage

/**
 * Created by januszsidor on 09/08/14.
 */
@CompileStatic
@Slf4j
@Service
class SenderService {
    @Autowired
    JmsTemplate template;
    final static String PAIR_ID = "PAIR_ID"
    final static String TOPIC_NAME = "facebook";


    public void post(String data, long pairId){
       template.send(TOPIC_NAME, new MessageCreator() {
           public Message createMessage(Session session) throws JMSException {
               TextMessage message = session.createTextMessage(data);
               message.setLongProperty(PAIR_ID, pairId);
               log.info("Sending for pairID {} message: {}",  pairId, data);
               return message;
           }
       })
    }
}
