package com.zhangyu.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.zhangyu.model.Customer;
import com.zhangyu.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value="Get customers by name")
    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getCustomers(@RequestParam("name") String name){
        return customerService.getCustomers(name);
    }

    @ApiOperation(value="Get customer by customer ID")
    @RequestMapping(value = "/customers/{customerId}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomer(@PathVariable int customerId) {
        return customerService.getCustomer(customerId);
    }

    @ApiOperation(value="create customer")
    @RequestMapping(value = "/customers", method = POST)
    public Customer createCustomer(@RequestBody Customer customer) {
        return customerService.createCustomer(customer);
    }

}