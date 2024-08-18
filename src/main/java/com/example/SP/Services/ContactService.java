package com.example.SP.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.SP.Models.Contact;
import com.example.SP.Models.ContactForm;
import com.example.SP.Repo.ContactRepository;


@Service
public class ContactService {
    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private ContactRepository contactRepository;

    public void sendEmail(ContactForm contactForm) {
        // Save to database
        Contact contact = new Contact();
        contact.setName(contactForm.getName());
        contact.setSubject(contactForm.getSubject());
        contact.setEmail(contactForm.getEmail());
        contact.setMessage(contactForm.getMessage());
        contactRepository.save(contact);

        // Send email
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("your-email@example.com"); // Change to your email
        message.setSubject(contactForm.getSubject());
        message.setText("Name: " + contactForm.getName() + "\n" +
                "Email: " + contactForm.getEmail() + "\n" +
                "Message: " + contactForm.getMessage());
        emailSender.send(message);
    }
}
