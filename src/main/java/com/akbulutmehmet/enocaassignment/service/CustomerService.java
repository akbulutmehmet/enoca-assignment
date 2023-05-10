package com.akbulutmehmet.enocaassignment.service;

import com.akbulutmehmet.enocaassignment.dto.converter.CustomerDtoConverter;
import com.akbulutmehmet.enocaassignment.dto.request.CreateCustomerRequest;
import com.akbulutmehmet.enocaassignment.dto.request.UpdateCustomerRequest;
import com.akbulutmehmet.enocaassignment.dto.response.CustomerDto;
import com.akbulutmehmet.enocaassignment.dto.response.CustomerSearchDto;
import com.akbulutmehmet.enocaassignment.exception.CustomerException;
import com.akbulutmehmet.enocaassignment.model.Customer;
import com.akbulutmehmet.enocaassignment.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = true,rollbackFor = CustomerException.class)
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository, CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    @Transactional(readOnly = false)
    public CustomerDto createCustomer(CreateCustomerRequest createCustomerRequest) {
        Customer customer = new Customer();
        customer.setName(createCustomerRequest.getName());
        customer.setMiddleName(createCustomerRequest.getMiddleName());
        customer.setSurname(createCustomerRequest.getSurname());
        customer.setAge(createCustomerRequest.getAge());
        return customerDtoConverter.convert(customerRepository.save(customer));
    }

    public Set<CustomerDto> getAllCustomer() {
        return customerRepository.findAll().stream().map((customer) -> customerDtoConverter.convert(customer)).collect(Collectors.toSet());
    }

    public CustomerDto getCustomerById(String id) {
        return customerDtoConverter.convert(findById(id));
    }

    public Customer findById (String id) {
        return customerRepository.findById(id).orElseThrow(() -> new CustomerException("Customer could not find by id : "+id));
    }
    @Transactional(readOnly = false)
    public void deletCustomerById(String id) {
        customerRepository.deleteById(id);
    }

    @Transactional(readOnly = false)
    public CustomerDto updateCustomer(String id, UpdateCustomerRequest updateCustomerRequest) {
        Customer customer = findById(id);
        customer.setName(updateCustomerRequest.getName());
        customer.setMiddleName(updateCustomerRequest.getMiddleName());
        customer.setSurname(updateCustomerRequest.getSurname());
        customer.setAge(updateCustomerRequest.getAge());
        return customerDtoConverter.convert(customerRepository.save(customer));
    }

    public Set<CustomerDto> getCustomerEmptyOrder() {
        return customerRepository.findCustomerByOrders_Empty().stream().map((customer) -> customerDtoConverter.convert(customer)).collect(Collectors.toSet());
    }

    public Set<CustomerSearchDto> searchCustomerByName (String s){
        List<Customer> customers = customerRepository.searchForCustomer(s);
        Set<CustomerSearchDto> customerSearchDtos = null;
        if(customers.size() > 0 && customers != null) {
            customerSearchDtos = customers.stream().map((customer) -> customerDtoConverter.convertToSearchDto(customer)).collect(Collectors.toSet());
        }
        return customerSearchDtos;
    }
}
