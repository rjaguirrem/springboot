package com.rjaguirrem.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

/**
 * Customer model.
 * @author Raúl Aguirre
 * @version 27/09/2022
 */
@Entity
@Data
@Table(name = "customer")
public class Customer {
  /** Customer id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "customerId")
  private Long id;

  /** First name. */
  private String firstName;

  /** Last name. */
  private String lastName;

  /** Birth date (dd/mm/yyyy). */
  private String birthDate;

  /** Sale list. */
  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JsonBackReference
  @JoinTable(name = "customer_sale",
          joinColumns = @JoinColumn(name = "customerId", referencedColumnName = "customerId"),
          inverseJoinColumns = @JoinColumn(name = "saleId", referencedColumnName = "saleId"))
  private List<Sale> saleList;
}