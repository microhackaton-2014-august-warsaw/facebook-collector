package com.ofg.microservice.facebook

import groovy.transform.TypeChecked
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
@TypeChecked
class FacebookCollectorImpl implements FacebookCollector {

    private final FacebookRepository repository
    private final FacebookDataBroadcaster broadcaster

    @Autowired
    FacebookCollectorImpl(FacebookRepository repository, FacebookDataBroadcaster broadcaster) {
        this.broadcaster = broadcaster
        this.repository = repository
    }

    @Override
    void collectAndPassToAnalyzers(String facebookId, long pairId) {
        FacebookData data = repository.loadFacebookData(facebookId, pairId)
        broadcaster.broadcast(data, pairId)
    }
}