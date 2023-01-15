package com.example.retries.data.repositories;


import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.retries.data.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

}
