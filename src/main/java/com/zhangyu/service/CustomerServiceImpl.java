package com.zhangyu.service;

import com.zhangyu.exception.NoCustomerFoundException;
import com.zhangyu.model.Customer;
import com.zhangyu.model.CustomerEntity;
import com.zhangyu.repository.CustomerRepository;
import com.zhangyu.translator.CustomerTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.lang.String.format;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerTranslator customerTranslator;

    public List<Customer> getCustomers(String name) {
        List<CustomerEntity> customerEntity = customerRepository.findByName(name);
        return customerTranslator.translateToCustomerList(customerEntity);
    }

    public Customer createCustomer(Customer customer) {
        CustomerEntity customerEntity = customerTranslator.translateToEntity(customer);
        customerEntity = customerRepository.save(customerEntity);
        return customerTranslator.translateToCustomer(customerEntity);
    }

    public Customer getCustomer(int customerId) {
        CustomerEntity customerEntity = customerRepository.findOne(customerId);
        isCustomerExit(customerId, customerEntity);
        return customerTranslator.translateToCustomer(customerEntity);
    }

    private void isCustomerExit(int customerId, CustomerEntity customerEntity) {
        if(customerEntity == null){
            throw new NoCustomerFoundException(format("%d not found", customerId));
        }
    }

}
