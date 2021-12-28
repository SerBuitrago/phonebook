package com.phonebook.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.model.Contact;
import com.phonebook.repository.ContactRepository;
import com.phonebook.service.ContactService;
import com.phonebook.util.Phonebook;
import com.phonebook.util.exception.PhonebookException;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	ContactRepository contactRepository;

	@Override
	public Contact findById(String id) {
		if (!Phonebook.isString(id))
			throw new PhonebookException("El id del contacto no es valido");
		Optional<Contact> optional = contactRepository.findById(id);
		if (!optional.isPresent())
			throw new PhonebookException("No se ha encontrado ningun contacto con el id " + id + ".");
		return optional.get();
	}

	@Override
	public List<Contact> findByPhone(String phone) {
		return contactRepository.findByPhone(phone);
	}
	
	@Override
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

	@Override
	public Contact save(Contact contact) {
		contact = contactRepository.save(contact);
		return contact;
	}

	@Override
	public Contact update(Contact contact) {
		contact = contactRepository.save(contact);
		return contact;
	}
}
