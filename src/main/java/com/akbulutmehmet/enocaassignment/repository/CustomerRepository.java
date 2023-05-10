package com.akbulutmehmet.enocaassignment.repository;

import com.akbulutmehmet.enocaassignment.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer,String> {
    List<Customer> findCustomerByOrders_Empty();
}
