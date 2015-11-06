package com.zhangyu.controller;

import com.zhangyu.model.Customer;
import com.zhangyu.log.CustomerLogger;
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
        CustomerLogger logger = mock(CustomerLogger.class);

        setField(customerController, "customerService", customerService);
        setField(customerController, "customerLogger", logger);

        when(customerService.createCustomer(customer)).thenReturn(customer);
//        when(logger.logCustomer(anyObject()))
        customerController.createCustomer(customer);

        verify(customerService, times(1)).createCustomer(customer);

    }
}