package com.ofg.microservice.facebook

import com.ofg.base.MicroserviceIntegrationSpec
import org.junit.Test
import org.springframework.beans.factory.annotation.Autowired

class FacebookDataBroadcasterTest extends MicroserviceIntegrationSpec {

    @Autowired
    FacebookDataBroadcaster senderService

    @Test
    void "tets"() {
        expect:
        senderService.broadcast(new FacebookData(), 111L);
    }
}
