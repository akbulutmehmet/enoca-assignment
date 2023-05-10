package com.akbulutmehmet.enocaassignment.repository;

import com.akbulutmehmet.enocaassignment.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,String> {
}
