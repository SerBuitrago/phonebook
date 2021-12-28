package com.phonebook.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "Contact")
public class Contact {
	
	@Id
	private String _id;
	
	private String phone;
	private String name;
	private User user;
}
