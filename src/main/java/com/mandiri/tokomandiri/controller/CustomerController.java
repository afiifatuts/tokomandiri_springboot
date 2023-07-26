package com.mandiri.tokomandiri.controller;

import com.mandiri.tokomandiri.entity.Customer;
import com.mandiri.tokomandiri.service.CustomerService;
import com.mandiri.tokomandiri.utils.constant.ApiUrlConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiUrlConstant.CUSTOMER_PATH)
public class CustomerController {
    CustomerService customerService;

    @Autowired

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public Customer saveCustomer(@RequestBody Customer customer){
        return customerService.saveCustomer(customer);
    }
    @GetMapping("/{id}")
    public Customer getCustomerById(@PathVariable String id){
        return customerService.getCustomerById(id);
    }

    @GetMapping
    public Page<Customer> getALlCustomer(@RequestParam(name = "page") Integer pageNumber,
                                         @RequestParam(name = "size") Integer size){
        Pageable pageable = PageRequest.of(pageNumber,size);
        return customerService.getCustomerPerPage(pageable);
    }

    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable String id){
        customerService.deleteCustomer(id);
    }

    @PutMapping
    public Customer updateCustomer(@RequestBody Customer customer){
        return customerService.updateCustomer(customer);
    }
}
