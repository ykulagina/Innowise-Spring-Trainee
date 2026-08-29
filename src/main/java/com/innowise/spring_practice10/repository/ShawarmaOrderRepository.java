package com.innowise.spring_practice10.repository;

import com.innowise.spring_practice10.model.ShawarmaOrder;
import org.springframework.data.repository.CrudRepository;

public interface ShawarmaOrderRepository extends CrudRepository<ShawarmaOrder, Long> {
}
