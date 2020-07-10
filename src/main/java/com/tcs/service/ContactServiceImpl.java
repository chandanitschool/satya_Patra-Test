package com.tcs.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tcs.entity.ContactEntity;
import com.tcs.model.Contact;
import com.tcs.repository.ContactDtlsRepository;

@Service
public class ContactServiceImpl  implements ContactService{
	
	@Autowired
	private ContactDtlsRepository contactDtlsRepository;

	@Override
	public boolean saveContact(Contact c) {
		
		ContactEntity entity = new ContactEntity();
		BeanUtils.copyProperties(c, entity);
		
		ContactEntity savedentity = contactDtlsRepository.save(entity);
		
		return savedentity.getContactId()!=null;
	}

	@Override
	public List<Contact> getAllContact() {
		List<ContactEntity> list = contactDtlsRepository.findAll();
		List<Contact> contacts = new ArrayList<Contact>();
		list.forEach(entity -> {
			Contact c = new Contact();
			BeanUtils.copyProperties(entity, c);
			contacts.add(c);
		});
		return contacts;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactEntity> findById = contactDtlsRepository.findById(cid);
		if(findById.isPresent()) {
			ContactEntity entity = findById.get();
			Contact c = new Contact();
			BeanUtils.copyProperties(entity, c);
			return c;
			
		}
		return null;
		
	}

	@Override
	public boolean updateContact(Contact c) {
		return false;
	}

	@Override
	
	public boolean deleteContact(Integer cid) {
		contactDtlsRepository.deleteById(cid);
		
		return true;
	}

}
