package com.rjaguirrem.springboot.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

/**
 * Sale model.
 * @author Raúl Aguirre
 * @version 27/09/2022
 */
@Entity
@Data
@Table(name = "sale")
public class Sale {
  /** Sale id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "saleId")
  private Long id;

  /** Payment type. */
  private String paymentType;

  /** Paid date (dd/mm/yyyy). */
  private String paidDate;

  /** total sale amount. */
  private Double totalAmount;

  /** Invoice object. */
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "invoice_id")
  @JsonIgnore
  private Invoice invoice;

  /** Sale detail list. */
  @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sale")
  @JsonIgnore
  private List<SaleDetail> saleDetailList;

  /** Customer list. */
  @ManyToMany(cascade = CascadeType.ALL)
  @JsonBackReference
  @JoinTable(name = "customer_sale",
          joinColumns = @JoinColumn(name = "saleId",
                                      referencedColumnName = "saleId"),
          inverseJoinColumns = @JoinColumn(name = "customerId",
                                            referencedColumnName = "customerId"))
  private List<Customer> customerList;
}