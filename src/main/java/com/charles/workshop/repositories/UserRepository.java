package com.charles.workshop.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.charles.workshop.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, Long> {

	User findById(String id);
	User deleteById(String id);
}
