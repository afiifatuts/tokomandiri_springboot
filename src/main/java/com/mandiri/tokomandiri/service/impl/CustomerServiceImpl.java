package com.mandiri.tokomandiri.service.impl;

import com.mandiri.tokomandiri.entity.Customer;
import com.mandiri.tokomandiri.repository.CustomerRepository;
import com.mandiri.tokomandiri.repository.ProductRepository;
import com.mandiri.tokomandiri.service.CustomerService;
import com.mandiri.tokomandiri.utils.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if(customerRepository.findById(customer.getCustomer_id()).isPresent()){
            return customerRepository.save(customer);
        }else {
            throw new DataNotFoundException("Product with ID " + customer.getCustomer_id() + " not found in the database.");
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        return null;
    }

    @Override
    public Customer getCustomerById(String customerId) {
        return customerRepository.findById(customerId).get();
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> getCustomerPerPage(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }
}
