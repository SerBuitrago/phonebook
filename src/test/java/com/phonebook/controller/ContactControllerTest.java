package com.phonebook.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.phonebook.model.Contact;
import com.phonebook.model.User;
import com.phonebook.repository.ContactRepository;
import com.phonebook.service.ContactService;
import com.phonebook.service.impl.ContactServiceImpl;

public class ContactControllerTest {

	ContactRepository contactRepositoryMock = Mockito.mock(ContactRepository.class);

	@Autowired
	ContactService contactService = new ContactServiceImpl(contactRepositoryMock);

	@Autowired
	ContactController contactController = new ContactController(contactService);
	
	Contact contactMockAdd = new Contact("4", "Julian Marquez", "3012239232", new User("Sergio Buitrago", "3118938189"));

	@BeforeEach
	void setUp() {
		/**
		 * Fill
		 */
		List<Contact> listMock = new ArrayList<>();
		listMock.add(new Contact("1", "Claudia Buitrago", "3114794520", new User("Sergio Buitrago", "3118938189")));
		listMock.add(new Contact("2", "Jhonatan Barrios", "3219039281", new User("Sergio Buitrago", "3118938189")));
		listMock.add(new Contact("3", "Rafael Barrios", "3127689319", new User("Sergio Buitrago", "3118938189")));
		
		Optional<Contact> optionalMock = Optional.of(listMock.get(0));
		
		/**
		 * When
		 */
		Mockito.when(contactRepositoryMock.findById("1")).thenReturn(optionalMock);
		Mockito.when(contactRepositoryMock.findByPhoneAndUserPhone("3114794520", "3118938189"))
				.thenReturn(optionalMock.get());
		Mockito.when(contactRepositoryMock.findAll()).thenReturn(listMock);
		Mockito.when(contactRepositoryMock.findByPhone("3114794520")).thenReturn(listMock);
		Mockito.when(contactRepositoryMock.findByUserPhone("3118938189")).thenReturn(listMock);
		Mockito.when(contactRepositoryMock.save(listMock.get(0))).thenReturn(listMock.get(0));
		Mockito.when(contactRepositoryMock.save(contactMockAdd)).thenReturn(contactMockAdd);
	}

	@Test
	void findById() {
		ResponseEntity<Contact> response = contactController.findById("1");
		Assertions.assertEquals("3114794520", response.getBody().getPhone());
	}

	@Test
	void findByPhoneAndUserPhone() {
		ResponseEntity<Contact> response = contactController.findByPhoneAndUserPhone("3114794520", "3118938189");
		Assertions.assertEquals("3114794520", response.getBody().getPhone());
	}

	@Test
	void findAll() {
		ResponseEntity<List<Contact>> response = contactController.findAll();
		Assertions.assertNotEquals(true, response.getBody().isEmpty());
	}

	@Test
	void findByPhone() {
		ResponseEntity<List<Contact>> response = contactController.findByPhone("3114794520");
		Assertions.assertNotEquals(true, response.getBody().isEmpty());
	}

	@Test
	void findByUserPhone() {
		ResponseEntity<List<Contact>> response = contactController.findByUserPhone("3118938189");
		Assertions.assertNotEquals(true, response.getBody().isEmpty());
	}

	@Test
	void save() {
		ResponseEntity<Contact> response = contactController.save(contactMockAdd);
		Assertions.assertNotNull(response.getBody());
	}

	@Test
	void update() {
		Contact contact = new Contact("1", "Claudia Buitrago", "3114794520", new User("Sergio Buitrago", "3118938189"));
		ResponseEntity<Contact> response = contactController.update(contact);
		Assertions.assertNotNull(response.getBody());
	}

	@Test
	void delete() {
		//ResponseEntity<Boolean> response = contactController.delete("1");
		//Assertions.assertEquals(true, response.getBody());
	}
}
