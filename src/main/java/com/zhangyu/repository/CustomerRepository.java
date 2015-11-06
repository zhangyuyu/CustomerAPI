package com.zhangyu.repository;

import com.zhangyu.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByFirstName(String firstName);
}