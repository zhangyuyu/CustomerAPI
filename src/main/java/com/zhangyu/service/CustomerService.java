package com.zhangyu.service;

import com.zhangyu.exception.NoCustomerFoundException;
import com.zhangyu.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers(String name);
    Customer createCustomer(Customer customer) ;
    Customer getCustomer(int customerId) throws NoCustomerFoundException;
}
