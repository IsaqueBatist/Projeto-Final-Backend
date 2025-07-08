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

import br.gov.sp.itu.fatec.backend.entities.Group;
import br.gov.sp.itu.fatec.backend.services.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Grupos", description = "Operações de gerenciamento de grupos")
@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @Operation(summary = "Listar todos os grupos")
    @GetMapping
    public ResponseEntity<List<Group>> findAll() {
        List<Group> groups = groupService.findAll();
        return ResponseEntity.ok(groups);
    }

    @Operation(summary = "Buscar grupo por ID")
    @GetMapping("/{id}")
    public ResponseEntity<Group> findById(@PathVariable Long id) {
        Group group = groupService.findById(id);
        return ResponseEntity.ok(group);
    }

    @Operation(summary = "Criar novo grupo")
    @PostMapping
    public ResponseEntity<Group> create(@RequestBody Group group) {
        Group created = groupService.save(group);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @Operation(summary = "Atualizar grupo")
    @PutMapping("/{id}")
    public ResponseEntity<Group> update(@PathVariable Long id, @RequestBody Group group) {
        group.setId(id);
        Group updated = groupService.save(group);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Atualização parcial do grupo")
    @PatchMapping("/{id}")
    public ResponseEntity<Void> partialUpdate(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        groupService.parcialUpdate(id, fields);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Excluir grupo")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }
}