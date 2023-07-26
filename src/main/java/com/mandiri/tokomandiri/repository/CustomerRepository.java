package com.mandiri.tokomandiri.repository;

import com.mandiri.tokomandiri.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
