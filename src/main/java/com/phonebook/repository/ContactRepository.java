package com.phonebook.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.phonebook.model.Contact;

@Repository
public interface ContactRepository extends MongoRepository<Contact, String>{
	
	List<Contact> findByPhone(String phone);
}
