package com.test.model.data;

import org.springframework.data.repository.CrudRepository;

import com.test.model.Rating;

public interface RatingRepository extends CrudRepository<Rating, Long> {

}