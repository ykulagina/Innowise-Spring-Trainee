package com.innowise.spring_practice10.repository;

import com.innowise.spring_practice10.model.Shawarma;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ShawarmaRepository extends CrudRepository<Shawarma, Long> {
    Page<Shawarma> findAll(Pageable pageable);
}
