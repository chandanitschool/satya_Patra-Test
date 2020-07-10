package com.tcs.service;

import java.util.List;

import com.tcs.model.Contact;

public interface ContactService {
	
	public boolean saveContact(Contact c);
	
	
	List<Contact> getAllContact();
	
	Contact getContactById(Integer cid);
	
	boolean updateContact(Contact c);
	
	boolean deleteContact(Integer cid);
	 
	 

}
