package com.zhangyu.service;

import com.zhangyu.entity.Customer;
import com.zhangyu.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    @Value("${message}")
    private String message;

    @Autowired
    private CustomerRepository customerRepository;


    public List<Customer> getCustomerByName(String name) {
        List<Customer> customers = customerRepository.findByFirstName(name);
        return customers;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }



}
