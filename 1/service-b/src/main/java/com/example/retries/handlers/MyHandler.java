package com.example.retries.handlers;

import org.springframework.stereotype.Component;

import com.example.retries.dtos.MyDto;

import lombok.RequiredArgsConstructor;

import org.hibernate.exception.GenericJDBCException;

@Component
@RequiredArgsConstructor
public class MyHandler {

    public MyDto doSomething(final MyDto myDto) {

        //something goes wrong
        throw new GenericJDBCException("Some DB Connection Problem", new java.sql.SQLException() );

    }

}
