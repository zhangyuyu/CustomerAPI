package com.zhangyu.service;

import com.zhangyu.repository.CustomerRepository;
import com.zhangyu.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    @Value("${message}")
    private String message;

    @Autowired
    private CustomerRepository customerRepository;


    public Customer getCustomerByName(String name) {
        Customer customer = customerRepository.findByFirstName(name);
        return customer;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }



}
