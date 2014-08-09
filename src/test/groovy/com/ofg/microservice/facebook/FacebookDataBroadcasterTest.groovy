package com.ofg.microservice.facebook

import com.ofg.base.MicroserviceIntegrationSpec
import com.ofg.microservice.Application
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

class FacebookDataBroadcasterTest extends MicroserviceIntegrationSpec {
    @Autowired
    FacebookDataBroadcaster senderService

    @Test
    void testPost() {
        senderService.broadcast(new FacebookData(), 111L);
    }
}
