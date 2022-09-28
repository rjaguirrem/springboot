package com.rjaguirrem.springboot.util;

import com.rjaguirrem.springboot.model.Customer;
import lombok.Data;

import java.util.List;

@Data
public class CustomerList {
  private List<Customer> customerList;
}
