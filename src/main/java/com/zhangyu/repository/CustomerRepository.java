package com.zhangyu.repository;

import com.zhangyu.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findByFirstName(String firstName);
}