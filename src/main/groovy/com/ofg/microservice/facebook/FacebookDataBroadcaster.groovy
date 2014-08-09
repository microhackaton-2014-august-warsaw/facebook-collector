package com.ofg.microservice.facebook

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.ObjectWriter
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageBuilder
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Slf4j
@Component
@TypeChecked
class FacebookDataBroadcaster {
    final static String TOPIC_NAME = "facebook";
    @Autowired
    RabbitTemplate template;

    public void broadcast(FacebookData data, long pairId){
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(data);

        Message message = MessageBuilder.withBody(json.getBytes())
               	.setContentType(MessageProperties.CONTENT_TYPE_JSON)
               	.setMessageId(String.valueOf(pairId))
               	.build();

        template.send(TOPIC_NAME, "", message);
    }
}
