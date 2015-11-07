package com.zhangyu.controller;

import com.wordnik.swagger.annotations.ApiOperation;
import com.zhangyu.exception.NoCustomerFoundException;
import com.zhangyu.log.CustomerLogger;
import com.zhangyu.model.Customer;
import com.zhangyu.model.CustomerEntity;
import com.zhangyu.service.CustomerService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.zhangyu.translator.CustomerTranslator.translateToCustomer;
import static com.zhangyu.translator.CustomerTranslator.translateToCustomerList;
import static com.zhangyu.translator.CustomerTranslator.translateToEntity;

@RestController
public class CustomerController {
    final Logger LOGGER=Logger.getLogger(CustomerLogger.class);

    @Value(value = "${no.customer.message}")
    private String noCustomer;

    @Value(value = "${get.customer.message}")
    private String getByName;

    @Value(value = "${create.customer.message}")
    private String createCustomer;

    @Autowired
    private CustomerService customerService;

    @ApiOperation(value="Get customer")
    @RequestMapping(value = "/customers/{name}")
    @ResponseBody
    public List<Customer> getCustomer(@PathVariable String name) throws NoCustomerFoundException {
        List<CustomerEntity> customerEntityList = customerService.getCustomerByname(name);
        if(customerEntityList.size() == 0) {
            LOGGER.info(noCustomer);
            throw new NoCustomerFoundException("no customer");
        }
        LOGGER.info(getByName);
        return translateToCustomerList(customerEntityList);
    }

    @ApiOperation(value="create customer")
    @RequestMapping(value = "/customers", method = RequestMethod.POST)
    public Customer createCustomer(@RequestBody Customer customer) {
        CustomerEntity customerEntity = customerService.createCustomer(translateToEntity(customer));
        LOGGER.info(createCustomer);
        return translateToCustomer(customerEntity);
    }

}