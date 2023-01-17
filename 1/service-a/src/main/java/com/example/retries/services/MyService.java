package com.example.retries.services;

import org.springframework.stereotype.Component;

import com.example.retries.dtos.MyDto;

import com.example.retries.services.clients.MyRestClient;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class MyService {

    private final MyRestClient myRestClient;

    public MyDto doSomething(final MyDto myDto) {
        return myRestClient.doPostRequest( myDto );
    }

}
