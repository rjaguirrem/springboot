package com.rjaguirrem.springboot.repository;

import com.rjaguirrem.springboot.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Customer repository.
 * @author Raúl Aguirre
 * @version 27/09/2022
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  public Customer findByFirstName(String firstName);
}
