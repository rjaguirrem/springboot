package com.rjaguirrem.springboot.service;

import com.rjaguirrem.springboot.model.Sale;
import java.util.List;

/**
 * Sale interface.
 * @author Raúl Aguirre
 * @version 27/09/2022
 */
public interface SaleService {
  Sale saveCrud(Sale sale);

  List<Sale> findAllCrud();
}

