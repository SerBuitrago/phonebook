package com.phonebook.service;

import java.util.List;

import com.phonebook.model.Contact;

public interface ContactService {
	
	Contact findById(String id);
	
	List<Contact> findByPhone(String phone);
	
	List<Contact> findAll();
	
	Contact save(Contact contact);
	
	Contact update(Contact contact);
}
