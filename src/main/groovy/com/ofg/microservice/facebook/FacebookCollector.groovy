package com.ofg.microservice.facebook

import org.springframework.scheduling.annotation.Async

public interface FacebookCollector {

    @Async
    void collectAndPassToAnalyzers(String facebookId, long pairId)

}
