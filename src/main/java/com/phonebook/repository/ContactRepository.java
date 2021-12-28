package com.phonebook.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.phonebook.model.Contact;

@Repository
public interface ContactRepository extends MongoRepository<Contact, String>{
	
	@Query(value = "{phone: ?0, 'user.phone': ?1 }")
	Contact findByPhoneAndUserPhone(String phoneContact, String phoneUser);
	
	List<Contact> findByPhone(String phone);
	
	@Query(value = "{'user.phone': ?0 }")
	List<Contact> findByUserPhone(String phone);
}
