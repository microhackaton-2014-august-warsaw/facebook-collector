package com.ofg.microservice.facebook

import com.ofg.base.MicroserviceMvcWiremockSpec
import org.springframework.beans.factory.annotation.Autowired

class FacebookDataBroadcasterTest extends MicroserviceMvcWiremockSpec {

    @Autowired
    FacebookDataBroadcaster broadcaster

    def 'testPost'() {
        broadcaster.broadcast(new FacebookData(), 111L);
    }
}
