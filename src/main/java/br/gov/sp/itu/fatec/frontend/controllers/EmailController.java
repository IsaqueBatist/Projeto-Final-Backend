package br.gov.sp.itu.fatec.frontend.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.itu.fatec.frontend.entities.Email;
import br.gov.sp.itu.fatec.frontend.services.EmailService;

@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailService service;

    @GetMapping
    public ResponseEntity<List<Email>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Email> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEmailById(id));
    }

    @PostMapping
    public ResponseEntity<Email> create(@RequestBody Email email) {
        Email saved = service.save(email);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Email> update(@PathVariable Long id, @RequestBody Email email) {
        email.setId(id);
        return ResponseEntity.ok(service.save(email));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        service.parcialUpdate(id, fields);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
