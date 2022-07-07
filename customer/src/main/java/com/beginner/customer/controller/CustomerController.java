package com.beginner.first.controller;

import com.beginner.first.VO.ResponseTemplateVO;
import com.beginner.first.entity.Customer;
import com.beginner.first.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@Slf4j
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer add(@RequestBody Customer customer){
        return customerService.add(customer);
    }

    @GetMapping
    public List<Customer> getAll(){
        log.info("Inside getAll method of CustomerController");
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getCustomerWithDepartment(@PathVariable("id") Long customerId){
        log.info("Inside getCustomerWithDepartment of CustomerController");
        return customerService.getCustomerWithDepartment(customerId);
    }

}
