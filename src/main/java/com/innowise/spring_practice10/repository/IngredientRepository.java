package com.innowise.spring_practice10.repository;

import com.innowise.spring_practice10.model.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
