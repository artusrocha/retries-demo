package com.example.retries.api.rest;

import  org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.retries.services.MyService;
import com.example.retries.dtos.MyDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MyRestController {
    
    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(MyRestController.class);

    private final MyService myService;

    @PostMapping()
    public ResponseEntity<MyDto> doSomething(@RequestBody final MyDto myDto) {

        log.info(myDto.toString());

        final MyDto result = myService.doSomething( myDto );

        return ResponseEntity.ok(result);
    }
}
