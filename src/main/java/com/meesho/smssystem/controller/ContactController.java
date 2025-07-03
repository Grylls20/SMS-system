package com.meesho.smssystem.controller;

import com.meesho.smssystem.model.Contact;
import com.meesho.smssystem.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/contacts")
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @PostMapping
    public Contact addContact(@RequestBody Contact contact) {
        return contactRepository.save(contact);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactRepository.deleteById(id);
    }
}

// ContactController is already implemented with endpoints to get, add, and delete contacts.
// No changes needed here for basic contact management.
