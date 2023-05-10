package com.akbulutmehmet.enocaassignment.service;

import com.akbulutmehmet.enocaassignment.dto.converter.OrderDtoConverter;
import com.akbulutmehmet.enocaassignment.dto.request.CreateOrderRequest;
import com.akbulutmehmet.enocaassignment.dto.request.UpdateOrderRequest;
import com.akbulutmehmet.enocaassignment.dto.response.OrderDto;
import com.akbulutmehmet.enocaassignment.exception.OrderException;
import com.akbulutmehmet.enocaassignment.model.Customer;
import com.akbulutmehmet.enocaassignment.model.Order;
import com.akbulutmehmet.enocaassignment.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = true,rollbackFor = OrderException.class)
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderDtoConverter orderDtoConverter;
    private final CustomerService customerService;
    public OrderService(OrderRepository orderRepository, OrderDtoConverter orderDtoConverter, CustomerService customerService) {
        this.orderRepository = orderRepository;
        this.orderDtoConverter = orderDtoConverter;
        this.customerService = customerService;
    }

    public Set<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream().map((order) -> orderDtoConverter.convert(order)).collect(Collectors.toSet());
    }
    public Order findById(String id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderException("Order could not find by id : "+ id ));
    }
    public OrderDto getOrderById(String id) {
        return orderDtoConverter.convert(findById(id));
    }

    @Transactional(readOnly = false)
    public OrderDto createOrder(CreateOrderRequest createOrderRequest) {
        Customer customer = customerService.findById(createOrderRequest.getCustomerId());
        Order order = new Order();
        order.setCustomer(customer);
        order.setTotalPrice(createOrderRequest.getTotalPrice());
        order.setCreationDate(new Date());
        return orderDtoConverter.convert(orderRepository.save(order));
    }

    @Transactional(readOnly = false)
    public OrderDto updateOrder(UpdateOrderRequest updateOrderRequest, String id) {
        Order order = findById(id);
        order.setTotalPrice(updateOrderRequest.getTotalPrice());
        return orderDtoConverter.convert(orderRepository.save(order));
    }

    @Transactional(readOnly = false)
    public void deleteOrderById(String id) {
        orderRepository.deleteById(id);
    }
}
