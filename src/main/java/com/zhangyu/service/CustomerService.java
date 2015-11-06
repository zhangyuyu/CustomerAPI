package com.zhangyu.service;

import com.zhangyu.model.Customer;

import java.util.List;

public interface CustomerService {
    public List<Customer> getCustomerByFirstName(String name);
    public Customer createCustomer(Customer customer) ;
}
