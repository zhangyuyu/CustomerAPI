package com.zhangyu.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.zhangyu.entity.Customer;
import com.zhangyu.exception.NoCustomerFoundException;
import com.zhangyu.log.LogCustomer;
import com.zhangyu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Configuration
@ComponentScan
public class CustomerController {
    @Value(value = "${no.customer.message}")
    private String noCustomer;

    @Value(value = "${get.customer.message}")
    private String getByFirstName;

    @Autowired
    private CustomerService customerService;

    LogCustomer log=new LogCustomer();

    public CustomerController() {
    }

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @ApiOperation(value="Get customer")
    @RequestMapping(value = "/customers/{firstName}")
    @ResponseBody
    public List<Customer> getCustomer(@PathVariable String firstName) throws NoCustomerFoundException {
        List<Customer> customers = customerService.getCustomerByFirstName(firstName);
        if(customers.size() == 0) {
            log.logMessage(noCustomer);
            throw new NoCustomerFoundException("no customer");
        }
        log.logMessage(getByFirstName);
        return customers;
    }

    @ApiOperation(value="create customer")
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) {
        log.logCustomer(customer);
        return customerService.save(customer);
    }

}