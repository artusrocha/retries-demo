package com.example.retries.services.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.retries.dtos.MyDto;

@FeignClient(name="myServiceB", url="${app.services.service-b}")
public interface MyRestClient {
    
    @PostMapping()
    MyDto doPostRequest(@RequestBody MyDto myDto);

}
