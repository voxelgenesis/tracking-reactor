package com.test.model.data;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import com.test.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
	
	public Collection<Ingredient> findByItem(String item);
	
	public Collection<Ingredient> findByUnit(String unit);

	public Collection<Ingredient> findDistinctByItem(String item);
	
	public Collection<Ingredient> findFirst3ByItem(String item);
	
	public long countByItem(String item);
}
