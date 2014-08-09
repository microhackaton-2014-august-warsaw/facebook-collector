package com.ofg.microservice.facebook

import org.springframework.social.facebook.api.FacebookProfile
import org.springframework.social.facebook.api.PagedList
import org.springframework.social.facebook.api.Post;

class FacebookData {

    String corelationId

    long pairId

    FacebookProfile profile

    PagedList<Post> feed

}
