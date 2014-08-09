package com.ofg.microservice.facebook

import groovy.transform.TypeChecked
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.social.facebook.api.Facebook
import org.springframework.social.facebook.connect.FacebookConnectionFactory
import org.springframework.social.oauth2.AccessGrant
import org.springframework.stereotype.Component

@Component
@TypeChecked
class FacebookCollectorImpl implements FacebookCollector {

    private final FacebookConnectionFactory connectionFactory

    @Autowired
    FacebookCollectorImpl(FacebookConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory
    }

    @Override
    void collectAndPassToAnalyzers(String facebookId, long pairId) {
        Facebook facebook = connectionFactory.createConnection(new AccessGrant('')).api
    }
}