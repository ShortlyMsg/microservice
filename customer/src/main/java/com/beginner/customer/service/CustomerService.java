package com.beginner.first.service;

import com.beginner.first.VO.Department;
import com.beginner.first.VO.ResponseTemplateVO;
import com.beginner.first.entity.Customer;
import com.beginner.first.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

    public CustomerService(CustomerRepository customerRepository, RestTemplate restTemplate) {
        this.customerRepository = customerRepository;

        this.restTemplate = restTemplate;
    }

    public Customer add(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAll() {
        log.info("Inside getAll of CustomerService");
        return customerRepository.findAll();
    }

    public ResponseTemplateVO getCustomerWithDepartment(Long customerId) {
        log.info("Inside getCustomerWithDepartment of CustomerService");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        Customer customer = customerRepository.findByCustomerId(customerId);

        Department department =
                restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+ customer.getDepartmentId()
                        , Department.class);

        vo.setCustomer(customer);
        vo.setDepartment(department);

        return vo;
    }
}
