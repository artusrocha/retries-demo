package com.example.retries.config;

import feign.RetryableException;
import feign.Retryer;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;

@Component
@NoArgsConstructor
public class FeignRetryer implements feign.Retryer {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(FeignRetryer.class);

    @Value("${retryer.retryMaxAttempt:5}")
    private int retryMaxAttempt;

    @Value("${retryer.retryInterval:2000}")
    private long retryInterval;

    private int attempt = 1;


    public FeignRetryer(int retryMaxAttempt, Long retryInterval) {
        this.retryMaxAttempt = retryMaxAttempt;
        this.retryInterval = retryInterval;
    }

    @Override
    public void continueOrPropagate(RetryableException e) {
        log.info("Feign retry attempt {} due to {} ", attempt, e.getMessage());

        if(attempt++ == retryMaxAttempt){
            throw e;
        }
        try {
            Thread.sleep(retryInterval);
        } catch (InterruptedException ignored) {
            Thread.currentThread().interrupt();
        }

    }

    @Override
    public Retryer clone() {
        return new FeignRetryer(retryMaxAttempt, retryInterval);
    }
}