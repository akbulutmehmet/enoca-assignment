package com.akbulutmehmet.enocaassignment.controller;

import com.akbulutmehmet.enocaassignment.dto.request.CreateOrderRequest;
import com.akbulutmehmet.enocaassignment.dto.request.UpdateOrderRequest;
import com.akbulutmehmet.enocaassignment.dto.response.OrderDto;
import com.akbulutmehmet.enocaassignment.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<Set<OrderDto>> getAllOrders () {
        return ResponseEntity.ok(orderService.getAllOrders());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<OrderDto> getOrderById (@PathVariable("id") String id){
        return ResponseEntity.ok(orderService.getOrderById(id));
    }
    @PostMapping
    public ResponseEntity<OrderDto>  createOrder (@Valid @RequestBody CreateOrderRequest createOrderRequest){
        return ResponseEntity.ok(orderService.createOrder(createOrderRequest));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<OrderDto> updateOrder (@Valid @RequestBody UpdateOrderRequest updateOrderRequest,
                                                 @PathVariable("id") String id){
        return ResponseEntity.ok(orderService.updateOrder(updateOrderRequest,id));
    }
    @DeleteMapping(value = "/{id}")
    public void deleleOrderById (@PathVariable("id") String id){
         orderService.deleteOrderById(id);
    }
}
