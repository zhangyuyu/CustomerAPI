package com.zhangyu.service;

import com.zhangyu.model.CustomerEntity;

import java.util.List;

public interface CustomerService {
    public List<CustomerEntity> getCustomerByname(String name);
    public CustomerEntity createCustomer(CustomerEntity customerEntity) ;
}
