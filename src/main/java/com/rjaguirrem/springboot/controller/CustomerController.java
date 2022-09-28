package com.rjaguirrem.springboot.controller;

import com.rjaguirrem.springboot.model.Customer;
import com.rjaguirrem.springboot.model.Sale;
import com.rjaguirrem.springboot.service.CustomerService;
import java.util.Collection;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Customer controller.
 * @author Raúl Aguirre
 * @version 27/09/2022
 */
@RestController
@RequestMapping("/api/customers")
public class CustomerController {
  @Autowired
  private CustomerService customerService;

  @GetMapping
  public ResponseEntity<Collection<Customer>> getCustomers() {
    return new ResponseEntity<>(customerService.getCustomers(), HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public Optional<Customer> getCustomerById(@PathVariable Long id) {
    return customerService.getCustomerById(id);
  }

  @GetMapping("/{id}/sale")
  public ResponseEntity<Collection<Sale>> getSaleByCustomer(@PathVariable Long id) {
    Customer customer = customerService.getCustomerById(id).orElseThrow();
    if (customer.getSaleList() != null) {
      return new ResponseEntity<>(customer.getSaleList(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping
  public ResponseEntity<?> saveCustomer(@RequestBody Customer customer) {
    return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
    customerService.deleteCustomer(id);
    return new ResponseEntity<Void>(HttpStatus.OK);
  }
}