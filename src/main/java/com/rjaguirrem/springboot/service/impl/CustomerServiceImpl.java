package com.rjaguirrem.springboot.service.impl;

import com.rjaguirrem.springboot.model.Customer;
import com.rjaguirrem.springboot.repository.CustomerRepository;
import com.rjaguirrem.springboot.service.CustomerService;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Customer service implementation.
 * @author Raúl Aguirre
 * @version 27/09/2022
 */
@Service
public final class CustomerServiceImpl implements CustomerService {
  private final CustomerRepository customerRepository;

  public CustomerServiceImpl(final CustomerRepository customerRepositoryInstance) {
    this.customerRepository = customerRepositoryInstance;
  }

  @Override
  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }

  @Override
  public Optional<Customer> getCustomerById(Long id) {
    return customerRepository.findById(id);
  }

  @Override
  public Customer getCustomerByFirstName(String firstName) {
    return customerRepository.findByFirstName(firstName);
  }

  @Override
  public Customer saveCustomer(Customer customer) {
    return customerRepository.save(customer);
  }

  @Override
  public void deleteCustomer(Long id) {
    customerRepository.deleteById(id);
  }

  @Override
  public void deleteCustomers() {
    customerRepository.deleteAll();
  }
}