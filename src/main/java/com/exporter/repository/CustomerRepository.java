package com.exporter.repository;

import com.exporter.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author Roman Voloboev
 */

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    Customer getCustomerByLogin(String login);
}