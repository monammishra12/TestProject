package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Customer;

/**
 * ProductCategoryRepository interface for entity productCategory
 * 
 * @author witty
 *
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
