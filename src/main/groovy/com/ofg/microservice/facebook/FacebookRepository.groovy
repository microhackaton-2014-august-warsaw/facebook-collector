package com.ofg.microservice.facebook

import com.ofg.infrastructure.web.filter.correlationid.CorrelationIdHolder
import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.social.facebook.api.Facebook
import org.springframework.social.facebook.api.PagingParameters
import org.springframework.stereotype.Component

@Slf4j
@Component
@TypeChecked
class FacebookRepository {

    private final Facebook facebook

    @Autowired
    FacebookRepository(Facebook facebook) {
        this.facebook = facebook
    }

    @Cacheable(FacebookConfig.CACHE_NAME)
    FacebookData loadFacebookData(String facebookId, long pairId) {
        return new FacebookData(
            corelationId: CorrelationIdHolder.get(),
            pairId: pairId,
            profile: facebook.userOperations().getUserProfile(),
            feed: facebook.feedOperations().getFeed(pagingParameters()))
    }

    private static PagingParameters pagingParameters() {
        return new PagingParameters(100, 0, null, null)
    }

}