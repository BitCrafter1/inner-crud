package com.da.innercrud1.service;

import com.da.innercrud1.dto.CustomerDto;
import com.da.innercrud1.exception.CustomerNotFoundException;
import com.da.innercrud1.mapper.CustomerMapper;
import com.da.innercrud1.model.Customer;
import com.da.innercrud1.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


    @Service
    public class CustomerService {

        private final CustomerMapper customerMapper;
        private final CustomerRepository customerRepository;

        @Autowired
        public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
            this.customerRepository = customerRepository;
            this.customerMapper = customerMapper;
        }

        public CustomerDto createCustomer(CustomerDto customerDto) {
            Customer customer = customerMapper.toModel(customerDto);
            Customer savedCustomer = customerRepository.save(customer);
            return customerMapper.toDto(savedCustomer);
        }

        public CustomerDto getCustomerById(Long id) {
            Customer customer = customerRepository.findById(id)
                    .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
            return customerMapper.toDto(customer);
        }

        public CustomerDto updateCustomer(Long id, CustomerDto customerDto) {
            Customer existingCustomer = customerRepository.findById(id)
                    .orElseThrow(() -> new CustomerNotFoundException("Customer not found"));
            customerMapper.updateCustomer(customerDto, existingCustomer);
            Customer updatedCustomer = customerRepository.save(existingCustomer);
            return customerMapper.toDto(updatedCustomer);
        }

        public void deleteCustomer(Long id) {
            if (!customerRepository.existsById(id)) {
                throw new CustomerNotFoundException("Customer not found");
            }
            customerRepository.deleteById(id);
        }
    }


