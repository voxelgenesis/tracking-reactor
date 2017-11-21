package com.test.model.data;

import org.springframework.data.repository.CrudRepository;

import com.test.model.User;


public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByName(String name);

}