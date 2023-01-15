package com.example.retries.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface ILoanedBookDto {

    @JsonIgnore
    UUID getCustomerId();
    UUID getBookId();
    String getBookName();
    String getBookDescription();
    LocalDateTime getLoanDateTime();

}