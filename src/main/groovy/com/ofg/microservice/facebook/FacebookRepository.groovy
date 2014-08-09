package com.ofg.microservice.facebook

import groovy.transform.TypeChecked
import groovy.util.logging.Slf4j
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.annotation.Cacheable
import org.springframework.social.facebook.api.Facebook

@Slf4j
@TypeChecked
class FacebookRepository {

    private final Facebook facebook

    @Autowired
    FacebookRepository(Facebook facebook) {
        this.facebook = facebook
    }

    @Cacheable(FacebookConfig.CACHE_NAME)
    FacebookData loadFacebookData(long pairId) {
        return new FacebookData()
    }

}