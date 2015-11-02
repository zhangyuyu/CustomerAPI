package com.zhangyu.controller;

import com.zhangyu.entity.Customer;
import com.zhangyu.service.CustomerService;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class CustomerControllerTest {

    @Test
    public void shouldCreateCustomer() throws Exception {
        Customer customer = new Customer();
        CustomerService customerService = mock(CustomerService.class);
        CustomerController customerController = new CustomerController(customerService);

        when(customerService.save(customer)).thenReturn(customer);
        customerController.createCustomer(customer);

        verify(customerService, times(1)).save(customer);

    }
}