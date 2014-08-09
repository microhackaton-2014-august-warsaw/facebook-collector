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

    final static String TOPIC_NAME = 'facebook';

    // FIXME use proper bean
    private final ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    final RabbitTemplate template;

    @Autowired
    FacebookDataBroadcaster(RabbitTemplate template) {
        this.template = template
    }

    public void broadcast(FacebookData data, long pairId){
        String json = ow.writeValueAsString(data);

        Message message = MessageBuilder.withBody(json.getBytes())
               	.setContentType(MessageProperties.CONTENT_TYPE_JSON)
               	.build();

        template.send(TOPIC_NAME, '', message);
    }
}
