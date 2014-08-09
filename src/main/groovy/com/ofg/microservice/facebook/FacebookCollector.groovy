package com.ofg.microservice.facebook

public interface FacebookCollector {

    void collectAndPassToAnalyzers(String facebookId, long pairId)

}
