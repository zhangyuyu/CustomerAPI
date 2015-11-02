package com.zhangyu.controller;

import com.zhangyu.entity.Customer;
import com.zhangyu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

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
    public Customer getCustomer(@PathVariable String name) {
        return customerService.getCustomerByName(name);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

}