package com.phonebook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.phonebook.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String>{

}
