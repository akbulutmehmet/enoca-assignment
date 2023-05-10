package com.akbulutmehmet.enocaassignment.repository;

import com.akbulutmehmet.enocaassignment.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {
}
