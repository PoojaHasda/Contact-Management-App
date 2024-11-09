package com.contactmanager.contact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contactmanager.contact.Entities.Contact;
import com.contactmanager.contact.services.Impl.ContactServiceImpl;


@RestController
@RequestMapping("/api")
public class ApiController {

    // get contact

    @Autowired
    private ContactServiceImpl contactService;

    @GetMapping("/contacts/{contactId}")
    public Contact getContact(@PathVariable String contactId) {
        return contactService.getById(contactId);
    }

}