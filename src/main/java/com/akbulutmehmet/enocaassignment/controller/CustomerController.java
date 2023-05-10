package com.akbulutmehmet.enocaassignment.controller;

import com.akbulutmehmet.enocaassignment.dto.request.CreateCustomerRequest;
import com.akbulutmehmet.enocaassignment.dto.response.CustomerDto;
import com.akbulutmehmet.enocaassignment.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping(value = "/api/v1/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer (@Valid @RequestBody CreateCustomerRequest createCustomerRequest){
        return ResponseEntity.ok(customerService.createCustomer(createCustomerRequest));
    }
    @GetMapping
    public ResponseEntity<Set<CustomerDto>> getAllCustomer () {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDto> getCustomerById (@PathVariable("id") String id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCustomerById (@PathVariable("id") String id){
         customerService.deletCustomerById(id);
    }
}
