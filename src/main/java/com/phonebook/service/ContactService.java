package com.phonebook.service;

import java.util.List;

import com.phonebook.model.Contact;

public interface ContactService {
	
	Contact findById(String id);
	
	Contact findByPhoneAndUserPhone(String phoneContact, String phoneUser);
	
	List<Contact> findByPhone(String phone);
	
	List<Contact> findAll();

	List<Contact> findByUserPhone(String phone);
	
	Contact save(Contact contact);
	
	Contact update(Contact contact);
	
	boolean deleteById(String id);
}
