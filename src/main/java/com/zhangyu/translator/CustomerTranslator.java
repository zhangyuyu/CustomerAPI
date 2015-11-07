package com.zhangyu.translator;

import com.zhangyu.model.Customer;
import com.zhangyu.model.CustomerEntity;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerTranslator {

    public CustomerEntity translateToEntity(Customer customer) {
        CustomerEntity customerEntity = new CustomerEntity();
        customerEntity.setName(customer.getName());
        customerEntity.setAge(customer.getAge());
        return customerEntity;
    }


    public Customer translateToCustomer(CustomerEntity customerEntity) {
        Customer customer = new Customer();
        customer.setCustomerID(customerEntity.getCustomerID());
        customer.setName(customerEntity.getName());
        customer.setAge(customerEntity.getAge());
        return customer;
    }

    public List<Customer> translateToCustomerList(List<CustomerEntity> customerEntityList) {
        List<Customer> customerList = new ArrayList<>();
        for (CustomerEntity customerEntity : customerEntityList){
            customerList.add(translateToCustomer(customerEntity));
        }
        return customerList;
    }
}
