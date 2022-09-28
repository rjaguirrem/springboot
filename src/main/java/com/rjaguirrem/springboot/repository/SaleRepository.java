package com.rjaguirrem.springboot.repository;

import com.rjaguirrem.springboot.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Sale repository.
 * @author Raúl Aguirre
 * @version 27/09/2022
 */
@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
}
