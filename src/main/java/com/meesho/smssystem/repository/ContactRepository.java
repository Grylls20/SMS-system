package com.meesho.smssystem.repository;

import com.meesho.smssystem.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findByPhoneNumber(String phoneNumber);
}
