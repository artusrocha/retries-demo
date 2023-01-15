package com.example.retries.dtos;

import java.util.List;
import java.util.UUID;

import lombok.Getter;
import lombok.Builder;

import com.example.retries.data.entities.Customer;

@Getter
@Builder
public class CustomerReportDto {

    private final UUID id;
    private final String firstName;
    private final String lastName;
    private final List<ILoanedBookDto> loanedBook;

    public static CustomerReportDto from(final Customer customer,
                                         final List<ILoanedBookDto> customerLoanedBooks) {
        return CustomerReportDto.builder()
            .id( customer.getId() )
            .firstName( customer.getFirstName() )
            .lastName( customer.getLastName() )
            .loanedBook( customerLoanedBooks )
            .build();
    }
}