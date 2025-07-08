package br.gov.sp.itu.fatec.backend.controllers;

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

import br.gov.sp.itu.fatec.backend.entities.Email;
import br.gov.sp.itu.fatec.backend.services.EmailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "E-mails", description = "Operações de gerenciamento de e-mails")
@RestController
@RequestMapping("/emails")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @Operation(summary = "Listar todos os e-mails")
    @GetMapping
    public ResponseEntity<List<Email>> findAll() {
        List<Email> emails = emailService.findAll();
        return ResponseEntity.ok(emails);
    }

    @Operation(summary = "Buscar e-mail por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Email> findById(@PathVariable Long id) {
        Email email = emailService.findById(id);
        return ResponseEntity.ok(email);
    }

    @Operation(summary = "Criar novo e-mail")
    @PostMapping
    public ResponseEntity<Email> create(@RequestBody Email email) {
        Email created = emailService.save(email);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Atualizar e-mail")
    @PutMapping("/{id}")
    public ResponseEntity<Email> update(@PathVariable Long id, @RequestBody Email email) {
        email.setId(id);
        Email updated = emailService.save(email);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Atualização parcial do e-mail")
    @PatchMapping("/{id}")
    public ResponseEntity<Void> partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        emailService.parcialUpdate(id, fields);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Excluir e-mail")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        emailService.delete(id);
        return ResponseEntity.noContent().build();
    }
}