package com.phonebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	@GetMapping(value = { "/{id}", "/find/id/{id}" })
	public ResponseEntity<?> findById(@PathVariable("id") String id) {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.findById(id));
	}
	
	@GetMapping(value = { "/find/phone/{phone}" })
	public ResponseEntity<?> findByPhone(@PathVariable("phone") String phone) {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.findByPhone(phone));
	}
	
	@GetMapping(value = { "", "/all" })
	public ResponseEntity<?> findAll() {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.findAll());
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody Contact contact) {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.save(contact));
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Contact contact) {
		return ResponseEntity.status(HttpStatus.OK).body(contactService.update(contact));
	}
}
