package com.rjaguirrem.springboot.model;

import javax.persistence.*;
import lombok.Data;

/**
 * SaleDetail model.
 * @author Raúl Aguirre
 * @version 27/09/2022
 */
@Entity
@Data
@Table(name = "sale_detail")
public class SaleDetail {
  /** Sale detail id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "saleDetailId")
  private Long id;

  /** Description. */
  private String description;

  /** Quantity. */
  private Integer quantity;

  /** Price. */
  private Double price;

  /** Sale object. */
  @ManyToOne
  @JoinColumn(name = "saleId")
  private Sale sale;
}