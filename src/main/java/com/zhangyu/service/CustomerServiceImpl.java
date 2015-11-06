package com.zhangyu.service;

import com.zhangyu.model.Customer;
import com.zhangyu.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomerByFirstName(String name) {
        return customerRepository.findByFirstName(name);
    }

    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

}
