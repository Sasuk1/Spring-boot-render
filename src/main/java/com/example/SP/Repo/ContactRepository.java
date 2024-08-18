package com.example.SP.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SP.Models.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
