package com.ofg.microservice.facebook

import com.ofg.microservice.Application
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
class FacebookDataBroadcasterTest extends GroovyTestCase {

    @Autowired
    FacebookDataBroadcaster broadcaster

    @Test
    void testPost() {
        broadcaster.broadcast(new FacebookData(), 111L);
    }
}
