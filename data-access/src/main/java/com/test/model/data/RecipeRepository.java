package com.test.model.data;

import org.springframework.data.repository.CrudRepository;

import com.test.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
