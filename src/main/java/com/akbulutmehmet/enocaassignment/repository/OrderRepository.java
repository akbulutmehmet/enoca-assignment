package com.akbulutmehmet.enocaassignment.repository;

import com.akbulutmehmet.enocaassignment.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,String> {
    List<Order> findByCreationDateAfter(Date date);
}
