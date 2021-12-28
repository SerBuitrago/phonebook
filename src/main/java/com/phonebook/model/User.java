package com.phonebook.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "User")
public class User {
	
	@Id
	private Long id;
	
	private String phone;
}
