package com.phonebook.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phonebook.model.Contact;
import com.phonebook.model.validate.ContactValidate;
import com.phonebook.repository.ContactRepository;
import com.phonebook.service.ContactService;
import com.phonebook.util.Phonebook;
import com.phonebook.util.exception.PhonebookException;

@Service
public class ContactServiceImpl implements ContactService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ContactServiceImpl.class);

	@Autowired
	ContactRepository contactRepository;

	@Override
	public Contact findById(String id) {
		if (!Phonebook.isString(id))
			throw new PhonebookException("El id del contacto no es valido.");
		Optional<Contact> optional = contactRepository.findById(id);
		if (!optional.isPresent())
			throw new PhonebookException("No se ha encontrado ningun contacto con el id " + id + ".");
		return optional.get();
	}

	@Override
	public Contact findByPhoneAndUserPhone(String phoneContact, String phoneUser) {
		if (!Phonebook.isString(phoneContact))
			throw new PhonebookException("El telefono del contacto no es valido.");
		if (!Phonebook.isString(phoneUser))
			throw new PhonebookException("El telefono del usuario no es valido.");
		Contact contact = contactRepository.findByPhoneAndUserPhone(phoneContact, phoneUser);
		if (contact == null)
			throw new PhonebookException("No se ha encontrado ningun contacto.");
		return contact;
	}

	@Override
	public List<Contact> findByPhone(String phone) {
		if (!Phonebook.isString(phone))
			throw new PhonebookException("El telefono del contacto no es valido.");
		return contactRepository.findByPhone(phone);
	}

	@Override
	public List<Contact> findAll() {
		return contactRepository.findAll();
	}

	@Override
	public List<Contact> findByUserPhone(String phone) {
		if (!Phonebook.isString(phone))
			throw new PhonebookException("El telefono del contacto no es valido.");
		return contactRepository.findByUserPhone(phone);
	}

	@Override
	public Contact save(Contact contact) {
		ContactValidate.validate(contact);
		if (!testPhone(contact.getPhone(), contact.getUser().getPhone()))
			throw new PhonebookException("Ese usuario ya tiene registrado ese contacto.");
		contact = contactRepository.save(contact);
		if (contact == null)
			throw new PhonebookException("No se ha registrado el contacto.");
		return contact;
	}

	@Override
	public Contact update(Contact contact) {
		ContactValidate.validate(contact);
		findById(contact.get_id());
		contact = contactRepository.save(contact);
		if (contact == null)
			throw new PhonebookException("No se ha actualizado el contacto.");
		return contact;
	}

	@Override
	public boolean deleteById(String id) {
		findById(id);
		contactRepository.deleteById(id);
		try {
			findByPhone(id);
		} catch (PhonebookException e) {
			LOGGER.error("deleteById(String id)", e);
			return true;
		}
		throw new PhonebookException("No se ha eliminado el contacto con el id " + id + ".");
	}

	private boolean testPhone(String a, String b) {
		Contact contact = null;
		try {
			contact = findByPhoneAndUserPhone(a, b);
		} catch (PhonebookException e) {
			LOGGER.error("testPhone(String a, String b)", e);
		}
		return contact == null ? true : false;
	}
}
