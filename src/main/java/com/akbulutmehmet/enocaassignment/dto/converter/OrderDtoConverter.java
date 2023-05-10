package com.akbulutmehmet.enocaassignment.dto.converter;

import com.akbulutmehmet.enocaassignment.dto.response.CustomerDto;
import com.akbulutmehmet.enocaassignment.dto.response.OrderDto;
import com.akbulutmehmet.enocaassignment.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoConverter {
    public OrderDto convert(Order order) {
        return new OrderDto(order.getId(),order.getTotalPrice(),order.getCreationDate(),order.getCustomer().getId());
    }
}
