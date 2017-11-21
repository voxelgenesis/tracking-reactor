package com.test.model.data;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.test.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
	
	public Collection<Ingredient> findByItem(String item);
}
