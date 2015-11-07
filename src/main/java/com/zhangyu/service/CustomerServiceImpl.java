package com.zhangyu.service;

import com.zhangyu.model.CustomerEntity;
import com.zhangyu.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    public List<CustomerEntity> getCustomerByname(String name) {
        return customerRepository.findByName(name);
    }

    public CustomerEntity createCustomer(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }

}
