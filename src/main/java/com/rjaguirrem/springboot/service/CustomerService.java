package com.rjaguirrem.springboot.service;

import com.rjaguirrem.springboot.model.Customer;
import java.util.List;
import java.util.Optional;

/**
 * Customer interface.
 * @author Raúl Aguirre
 * @version 27/09/2022
 */
public interface CustomerService {
  List<Customer> getCustomers();

  Optional<Customer> getCustomerById(Long id);

  Customer getCustomerByFirstName(String firstName);

  Customer saveCustomer(Customer customer);

  void deleteCustomer(Long id);

  void deleteCustomers();
}