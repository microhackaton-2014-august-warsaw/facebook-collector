package com.ofg.microservice.facebook

import org.springframework.social.facebook.api.FacebookProfile;

class FacebookData {

    @Delegate final FacebookProfile profile

    FacebookData(FacebookProfile profile) {
        this.profile = profile
    }
}
