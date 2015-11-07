package com.zhangyu.translator;

import com.zhangyu.model.Customer;
import com.zhangyu.model.CustomerEntity;

import java.util.ArrayList;
import java.util.List;

public class CustomerTranslator {

    public static CustomerEntity translateToEntity(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customer.getName());
        customerEntity.setAge(customer.getAge());
        return customerEntity;
    }


    public static Customer translateToCustomer(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setCustomerID(customerEntity.getCustomerID());
        customer.setName(customerEntity.getName());
        customer.setAge(customerEntity.getAge());
        return customer;
    }

    public static List<Customer> translateToCustomerList(List<CustomerEntity> customerEntityList) {
        List<Customer> customerList = new ArrayList<>();
        for (CustomerEntity customerEntity : customerEntityList){
            customerList.add(translateToCustomer(customerEntity));
        }
        return customerList;
    }
}
