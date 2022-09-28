package com.rjaguirrem.springboot.service;

import com.rjaguirrem.springboot.model.Customer;
import com.rjaguirrem.springboot.util.CustomerList;
import com.rjaguirrem.springboot.util.ReadFile;
import java.util.List;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("mysql")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CustomerServiceImplTest {
  @Autowired
  protected CustomerService customerService;

  @BeforeAll
  void savingCustomers() {
    CustomerList customerList = ReadFile.readDataFromFile("mock/customer-request.json", CustomerList.class);
    customerList.getCustomerList().forEach(
      customer -> customerService.saveCustomer(customer)
    );
  }

  @AfterAll
  void deletingCustomers() {
    customerService.deleteCustomers();
  }

  @Test
  @Order(1)
  @DisplayName("Validate list customers")
  public void validateListCustomers() {
    // given
    Integer items = 0;

    // when
    List<Customer> customers = customerService.getCustomers();

    // then
    assertThat(customers).size().isGreaterThan(items);
  }

  @Test
  @Order(2)
  @DisplayName("Find customer by firstname")
  public void findCustomerByFirstName(){
    // given
    String firstName = "Raúl";

    // when
    Customer customer = customerService.getCustomerByFirstName(firstName);

    // then
    assertThat(customer.getFirstName()).isEqualTo(firstName);
  }

  @Test
  @Order(3)
  @DisplayName("Update customer by firstname")
  @Rollback(false)
  public void updateCustomer(){
    // given
    String currentCustomerName = "Raúl";
    String newCustomerName = "Joseph";

    // when
    Customer customer = customerService.getCustomerByFirstName(currentCustomerName);
    customer.setFirstName(newCustomerName);

    customerService.saveCustomer(customer);

    Customer customerUpdate = customerService.getCustomerByFirstName(newCustomerName);

    // then
    assertThat(customerUpdate.getFirstName()).isEqualTo(newCustomerName);
  }
}