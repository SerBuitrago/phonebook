package com.phonebook.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "Contact")
public class Contact {
	
	@Id
	private String _id;
	
	private String name;
	private String phone;
	private User user;
}
