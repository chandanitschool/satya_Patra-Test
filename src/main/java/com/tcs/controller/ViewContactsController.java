package com.tcs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tcs.model.Contact;
import com.tcs.service.ContactService;

@Controller
public class ViewContactsController {

	@Autowired
	ContactService contactService;
	
	@GetMapping("/editContact")
	public String editContact(@RequestParam("cid") Integer contactId, Model model) {
		
		Contact c = contactService.getContactById(contactId);
		model.addAttribute("contact", c);
		
		return "contactForm";
		
	}
	
	@GetMapping("/deleteContact")
	public String deleteContact(@RequestParam("cid") Integer cid , Model model) {
		
		boolean isDeleted = contactService.deleteContact(cid);
		if(isDeleted) {
			return "redirect:/viewContacts";
		}
		return null;
		
		
	}
	
	
	
	
	
}
