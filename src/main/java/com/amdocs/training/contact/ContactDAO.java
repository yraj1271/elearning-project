package com.amdocs.training.contact;

import java.util.List;

public interface ContactDAO {

	List<Contact> findAll();

	boolean addContact(Contact contact);

	Contact getContactById(int id);

	boolean deleteContact(int id);
	
	boolean updateContact(Contact cont);
}
