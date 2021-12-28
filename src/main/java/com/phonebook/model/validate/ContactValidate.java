package com.phonebook.model.validate;

import com.phonebook.model.Contact;
import com.phonebook.util.Phonebook;
import com.phonebook.util.exception.PhonebookException;

public class ContactValidate {

	public static void validate(Contact contact) {
		if (contact == null)
			throw new PhonebookException("No se ha podido validar el contacto.");
		if (!Phonebook.isString(contact.getName()))
			throw new PhonebookException("El nombre del contacto no es valido.");
		if (!Phonebook.isString(contact.getPhone()))
			throw new PhonebookException("El telefono del contacto no es valido.");
		if (contact.getPhone().length() > 10)
			throw new PhonebookException("El telefono del contacto no es valido, no puede tener mas de 10 caracteres.");
		UserValidate.validate(contact.getUser());
	}
}
