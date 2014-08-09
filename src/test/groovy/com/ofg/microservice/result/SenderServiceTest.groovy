package com.ofg.microservice.result

import com.ofg.microservice.Application
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

/**
 * Created by januszsidor on 09/08/14.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Application.class, loader = SpringApplicationContextLoader.class)
class SenderServiceTest extends GroovyTestCase {
    @Autowired
    SenderService senderService
    @Test
    void testPost() {
        senderService.post("sasas", 111);
    }
}
