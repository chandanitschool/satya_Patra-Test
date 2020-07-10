package com.tcs.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tcs.model.Contact;
import com.tcs.service.ContactService;

@Controller
//@RequestMapping("/api")
public class ContactController {

	
	
	private static final Logger log = LoggerFactory.getLogger(ContactController.class);

	@Autowired
	private ContactService contactService;

	@GetMapping(value = { "/", "/contactForm" })
	public String loadForm(Model m) {

		Contact c = new Contact();
		m.addAttribute("contact", c);
		return "contactForm";
	}
	
	@PostMapping(value = "/addDetails")
	public String handledContactBtn(@ModelAttribute ("contact") Contact c , RedirectAttributes attr) {
		String msg="";
		
		boolean isSaved = contactService.saveContact(c);
		
		if(isSaved) {	
			msg= "contact added succesfully";
		}else {
			
			msg="failed to add";
		}
		attr.addFlashAttribute("msg", msg);
		return "redirect:/contactForm";
	}
	
	@GetMapping("/viewContacts")
	public String viewAllContacts(Model model) {
		List<Contact> contactList = contactService.getAllContact();
		model.addAttribute("contacts", contactList);
		return "viewContacts";
	}
}
