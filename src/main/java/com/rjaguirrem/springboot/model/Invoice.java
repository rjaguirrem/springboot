package com.rjaguirrem.springboot.model;

import javax.persistence.*;
import lombok.Data;

/**
 * Invoice model.
 * @author Raúl Aguirre
 * @version 27/09/2022
 */
@Entity
@Data
@Table(name = "invoice")
public class Invoice {
  /** Invoice id. */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "invoiceId")
  private Long id;

  /** Document type. */
  private String documentType;

  /** Document serial. */
  private String documentSerial;

  /** Document number. */
  private String documentNumber;
}