package com.phonebook.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.phonebook.model.Contact;
import com.phonebook.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
	
	@Autowired
	ContactService contactService;
	
	public ContactController(ContactService contactService) {
		this.contactService = contactService;
	}
	
	@GetMapping(value = { "/{id}", "/find/id/{id}" })
	public ResponseEntity<Contact> findById(@PathVariable("id") String id) {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.findById(id));
	}
	
	@GetMapping(value = { "/find/phone/{phoneContact}/user/phone/{phoneUser}" })
	public ResponseEntity<Contact> findByPhoneAndUserPhone(@PathVariable("phoneContact") String phoneContact,
			@PathVariable("phoneUser") String phoneUser) {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.findByPhoneAndUserPhone(phoneContact, phoneUser));
	}
	
	@GetMapping(value = { "", "/all" })
	public ResponseEntity<List<Contact>> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.findAll());
	}
	
	@GetMapping(value = { "/all/find/phone/{phone}" })
	public ResponseEntity<List<Contact>> findByPhone(@PathVariable("phone") String phone) {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.findByPhone(phone));
	}
	
	@GetMapping(value = { "/all/find/user/phone/{phone}" })
	public ResponseEntity<List<Contact>> findByUserPhone(@PathVariable("phone") String phone) {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.findByUserPhone(phone));
	}
	
	@PostMapping
	public ResponseEntity<Contact> save(@RequestBody Contact contact) {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.save(contact));
	}
	
	@PutMapping
	public ResponseEntity<Contact> update(@RequestBody Contact contact) {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.update(contact));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") String id) {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.deleteById(id));
	}
}
