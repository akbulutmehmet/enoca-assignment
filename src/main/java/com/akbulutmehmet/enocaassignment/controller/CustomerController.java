package com.akbulutmehmet.enocaassignment.controller;

import com.akbulutmehmet.enocaassignment.dto.request.CreateCustomerRequest;
import com.akbulutmehmet.enocaassignment.dto.request.UpdateCustomerRequest;
import com.akbulutmehmet.enocaassignment.dto.response.CustomerDto;
import com.akbulutmehmet.enocaassignment.dto.response.CustomerSearchDto;
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


    @GetMapping
    public ResponseEntity<Set<CustomerDto>> getAllCustomer () {
        return ResponseEntity.ok(customerService.getAllCustomer());
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<CustomerDto> getCustomerById (@PathVariable("id") String id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer (@Valid @RequestBody CreateCustomerRequest createCustomerRequest){
        return ResponseEntity.ok(customerService.createCustomer(createCustomerRequest));
    }
    @PutMapping(value = "/{id}")
    public ResponseEntity<CustomerDto> updateCustomer(@PathVariable("id") String id, @Valid @RequestBody UpdateCustomerRequest updateCustomerRequest) {
        return ResponseEntity.ok(customerService.updateCustomer(id,updateCustomerRequest));
    }
    @DeleteMapping(value = "/{id}")
    public void deleteCustomerById (@PathVariable("id") String id){
         customerService.deletCustomerById(id);
    }
    @GetMapping(value = "/empty-order")
    public ResponseEntity<Set<CustomerDto>> getCustomerEmptyOrder () {
        return ResponseEntity.ok(customerService.getCustomerEmptyOrder());
    }
    @GetMapping(value = "/search")
    public ResponseEntity<Set<CustomerSearchDto>> searchCustomerByName (@RequestParam("search") String s ){
        return ResponseEntity.ok(customerService.searchCustomerByName(s));
    }
}
