package br.gov.sp.itu.fatec.backend.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.gov.sp.itu.fatec.backend.entities.Contact;
import br.gov.sp.itu.fatec.backend.services.ContactService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Contatos", description = "Operações com contatos")
@RestController
@CrossOrigin
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService service;

    @Operation(summary = "Listar todos os contatos")
    @GetMapping
    public ResponseEntity<List<Contact>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @Operation(summary = "Buscar contato por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Contact> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @Operation(summary = "Criar um novo contato")
    @PostMapping
    public ResponseEntity<?> create(@RequestPart Contact contact, @RequestPart MultipartFile imageFile) {

        try{
            Contact saved = service.save(contact, imageFile);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        } catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @Operation(summary = "Atualizar um contato completamente")
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestPart Contact contact, @RequestPart MultipartFile imageFile) {
        contact.setId(id);
        try{
            Contact updateContact = service.save(contact, imageFile);
            return ResponseEntity.ok(updateContact);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    @Operation(summary = "Atualização parcial do contato")
    @PatchMapping("/{id}")
    public ResponseEntity<Void> partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        service.parcialUpdate(id, fields);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Excluir um contato")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Buscar contatos por nome (contendo, case-insensitive)")
    @GetMapping("/search/by-name")
    public ResponseEntity<List<Contact>> findByName(
        @Parameter(description = "Parte do nome a buscar", example = "joao")
        @RequestParam String name) {
        List<Contact> contacts = service.findByNameContainingIgnoreCase(name);
        return ResponseEntity.ok(contacts);
    }

    @Operation(summary = "Buscar contatos por número de telefone (contendo, case-insensitive)")
    @GetMapping("/search/by-phone")
    public ResponseEntity<List<Contact>> findByPhone(
        @Parameter(description = "Parte do número de telefone a buscar", example = "999")
        @RequestParam String number) {
        List<Contact> contacts = service.findByPhonesNumberContainingIgnoreCase(number);
        return ResponseEntity.ok(contacts);
    }

    @Operation(summary = "Buscar contatos por email (contendo, case-insensitive)")
    @GetMapping("/search/by-email")
    public ResponseEntity<List<Contact>> findByEmail(
        @Parameter(description = "Parte do email a buscar", example = "email@exemplo.com")
        @RequestParam String email) {
        List<Contact> contacts = service.findByEmailsEmailContainingIgnoreCase(email);
        return ResponseEntity.ok(contacts);
    }

    @Operation(summary = "Buscar contatos favoritos ou não")
    @GetMapping("/search/by-favorite")
    public ResponseEntity<List<Contact>> findByFavorite(
        @Parameter(description = "Buscar contatos favoritos? true ou false", example = "true")
        @RequestParam boolean favorite) {
        List<Contact> contacts = service.findByFavorite(favorite);
        return ResponseEntity.ok(contacts);
    }

    @Operation(summary = "Buscar contatos por nome de categoria (case-insensitive)")
    @GetMapping("/search/by-category")
    public ResponseEntity<List<Contact>> findByCategory(
        @Parameter(description = "Nome da categoria", example = "Amigos")
        @RequestParam String categoryName) {
        List<Contact> contacts = service.findByCategoriesNameIgnoreCase(categoryName);
        return ResponseEntity.ok(contacts);
    }

    @Operation(summary = "Buscar contatos por nome de grupo (contendo, case-insensitive)")
    @GetMapping("/search/by-group")
    public ResponseEntity<List<Contact>> findByGroup(
    @Parameter(description = "Parte do nome do grupo a buscar", example = "Família")
    @RequestParam String groupName) {
    List<Contact> contacts = service.findByGroupNameContainingIgnoreCase(groupName);
    return ResponseEntity.ok(contacts);
}
}
