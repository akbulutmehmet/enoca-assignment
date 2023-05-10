package com.akbulutmehmet.enocaassignment.service;

import com.akbulutmehmet.enocaassignment.exception.OrderException;
import com.akbulutmehmet.enocaassignment.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = true,rollbackFor = OrderException.class)
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }
}
