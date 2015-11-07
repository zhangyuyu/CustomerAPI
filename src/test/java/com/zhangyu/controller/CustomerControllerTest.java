package com.zhangyu.controller;

import com.zhangyu.model.Customer;
import com.zhangyu.model.CustomerEntity;
import com.zhangyu.service.CustomerService;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.springframework.test.util.ReflectionTestUtils.setField;

public class CustomerControllerTest {


    @Test
    public void shouldCreateCustomer() throws Exception {
        Customer customer = new Customer();
        CustomerEntity customerEntity = new CustomerEntity();
        CustomerService customerService = mock(CustomerService.class);
        CustomerController customerController = new CustomerController();

        setField(customerController, "customerService", customerService);
//        when(customerService.createCustomer(customerEntity)).thenReturn(customerEntity);
//        customerController.createCustomer(customer);

    }
}