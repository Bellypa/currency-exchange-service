package com.in29minutes.microservices.currencyexchangeservice;


import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CircuitBreakerController {

    private Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name = "default")
//    @Retry(name = "sample-api", fallbackMethod = "hardCodedResponse")


//    @CircuitBreaker(name = "default", fallbackMethod = "hardCodedResponse")


//    @RateLimiter(name = "default") // means in 10s => 10000 calls to the sample api

    @Bulkhead(name = "sample-api") // in configuration i set that bulk head will call service 10 times
    public String sampleApi() {

        logger.info("Sample Api call received");
//        ResponseEntity<String> forEntity = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url",String.class);
//        return forEntity.getBody();
        return "sample-api";
    }


    public String hardCodedResponse(Exception ex) {
        return "fallback-response";
    }
}
