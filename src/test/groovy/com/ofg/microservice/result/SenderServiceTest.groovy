package com.ofg.microservice.result

import com.ofg.base.MicroserviceIntegrationSpec
import com.ofg.microservice.Application
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationContextLoader
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

class SenderServiceTest extends MicroserviceIntegrationSpec {
    @Autowired
    SenderService senderService

    def 'asd'() {
        expect:
        senderService.post("sasas", 111);
    }
}
