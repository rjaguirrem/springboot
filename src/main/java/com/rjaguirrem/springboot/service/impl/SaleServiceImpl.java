package com.rjaguirrem.springboot.service.impl;

import com.rjaguirrem.springboot.model.Sale;
import com.rjaguirrem.springboot.repository.SaleRepository;
import com.rjaguirrem.springboot.service.SaleService;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.stereotype.Service;

/**
 * Sale service implementation.
 * @author Raúl Aguirre
 * @version 27/09/2022
 */
@Service
public final class SaleServiceImpl implements SaleService {
  private final SaleRepository saleRepositoryCrud;

  public SaleServiceImpl(final SaleRepository saleRepositoryCrudInstance) {
    this.saleRepositoryCrud = saleRepositoryCrudInstance;
  }

  @Override
  public Sale saveCrud(final Sale sale) {
    return saleRepositoryCrud.save(sale);
  }

  @Override
  public List<Sale> findAllCrud() {
    return StreamSupport.stream(
                    saleRepositoryCrud.findAll().spliterator(), false)
            .collect(Collectors.toList());
  }
}