package com.example.SP.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SP.Models.ContactForm;
import com.example.SP.Services.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @PostMapping
    public void sendEmail(@RequestBody ContactForm contactForm) {
        contactService.sendEmail(contactForm);
    }
}
