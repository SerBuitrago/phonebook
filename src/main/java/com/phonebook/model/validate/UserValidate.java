package com.phonebook.model.validate;

import com.phonebook.model.User;
import com.phonebook.util.Phonebook;
import com.phonebook.util.exception.PhonebookException;

public class UserValidate {
	public static void validate(User user) {
		if(user == null)
			throw new PhonebookException("No se ha podido validar el usuario.");
		if(!Phonebook.isString(user.getName()))
			throw new PhonebookException("No se ha recibido el nombre del usuario.");
		if(!Phonebook.isString(user.getPhone()))
			throw new PhonebookException("No se ha recibido el telefono del usuario.");
	}
}
