package com.test.model.data;

import org.springframework.data.repository.CrudRepository;

import com.test.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
