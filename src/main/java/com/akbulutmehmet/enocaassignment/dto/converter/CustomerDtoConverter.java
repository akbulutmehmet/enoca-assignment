package com.akbulutmehmet.enocaassignment.dto.converter;

import com.akbulutmehmet.enocaassignment.dto.response.CustomerDto;
import com.akbulutmehmet.enocaassignment.dto.response.OrderDto;
import com.akbulutmehmet.enocaassignment.model.Customer;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class CustomerDtoConverter {
    private final OrderDtoConverter orderDtoConverter;

    public CustomerDtoConverter(OrderDtoConverter orderDtoConverter) {
        this.orderDtoConverter = orderDtoConverter;
    }

    public CustomerDto convert(Customer customer) {
        Set<OrderDto> orderDtoSet = customer.
                getOrders().
                stream().map((order) -> orderDtoConverter.convert(order)).collect(Collectors.toSet());
        return new CustomerDto(customer.getId(),customer.getName(), customer.getMiddleName(), customer.getSurname(), customer.getAge(),orderDtoSet);
    }
}
