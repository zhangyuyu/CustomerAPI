package com.zhangyu.controller;

import com.zhangyu.entity.Customer;
import com.zhangyu.log.LogCustomer;
import com.zhangyu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Configuration
@ComponentScan
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    public CustomerController() {
    }

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping(value = "/firstName/{name}")
    @ResponseBody
    public List<Customer> getCustomer(@PathVariable String name) {
        List<Customer> customers = customerService.getCustomerByName(name);
        if(customers.size() == 0) return null;
        return customers;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) {
        LogCustomer log=new LogCustomer();
        log.logCustomer(customer);
        return customerService.save(customer);
    }

}