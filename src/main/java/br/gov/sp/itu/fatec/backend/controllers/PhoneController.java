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

import br.gov.sp.itu.fatec.backend.entities.Phone;
import br.gov.sp.itu.fatec.backend.services.PhoneService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Telefones", description = "Operações de gerenciamento de telefones")
@RestController
@RequestMapping("/phones")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @Operation(summary = "Listar todos os telefones")
    @GetMapping
    public ResponseEntity<List<Phone>> findAll() {
        List<Phone> phones = phoneService.findAll();
        return ResponseEntity.ok(phones);
    }

    @Operation(summary = "Buscar telefone por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Phone> findById(@PathVariable Long id) {
        Phone phone = phoneService.findById(id);
        return ResponseEntity.ok(phone);
    }

    @Operation(summary = "Criar novo telefone")
    @PostMapping
    public ResponseEntity<Phone> create(@RequestBody Phone phone) {
        Phone created = phoneService.save(phone);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Atualizar telefone")
    @PutMapping("/{id}")
    public ResponseEntity<Phone> update(@PathVariable Long id, @RequestBody Phone phone) {
        phone.setId(id);
        Phone updated = phoneService.save(phone);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Atualização parcial do telefone")
    @PatchMapping("/{id}")
    public ResponseEntity<Void> partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        phoneService.parcialUpdate(id, fields);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Excluir telefone")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        phoneService.delete(id);
        return ResponseEntity.noContent().build();
    }
}