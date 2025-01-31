package com.da.innercrud1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.da.innercrud1.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Optional<Customer> findByEmail(String email);
}
