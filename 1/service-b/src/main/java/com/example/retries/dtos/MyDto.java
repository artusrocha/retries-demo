package com.example.retries.dtos;

import lombok.Getter;
import lombok.ToString;
import javax.validation.constraints.NotNull;

@ToString
@Getter
public class MyDto {

    @NotNull
    private String field1;

    private String field2;
    
}
