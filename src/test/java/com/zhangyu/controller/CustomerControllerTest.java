package com.zhangyu.controller;

import com.zhangyu.model.Customer;
import com.zhangyu.service.CustomerService;
import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.springframework.test.util.ReflectionTestUtils.setField;

public class CustomerControllerTest {


    @Test
    public void shouldCreateCustomer() throws Exception {
        Customer customer = new Customer();
        CustomerService customerService = mock(CustomerService.class);
        CustomerController customerController = new CustomerController();

        setField(customerController, "customerService", customerService);
        when(customerService.createCustomer(customer)).thenReturn(customer);
        customerController.createCustomer(customer);

        verify(customerService, times(1)).createCustomer(customer);
    }
}