package br.gov.sp.itu.fatec.backend.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.itu.fatec.backend.entities.Contact;
import br.gov.sp.itu.fatec.backend.entities.Group;
import br.gov.sp.itu.fatec.backend.expections.EntityFoundException;
import br.gov.sp.itu.fatec.backend.repositories.ContactRepository;
import br.gov.sp.itu.fatec.backend.repositories.GroupRepository;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private ContactRepository contactRepository;

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group findById(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new EntityFoundException("Group not found"));
    }

    public Group save(Group group) {
        if (!groupRepository.existsByName(group.getName())) {
            return groupRepository.save(group);
        }else{
            Group existing = groupRepository.findByName(group.getName());
            return existing;
        }
    }

    public void parcialUpdate(Long id, Map<String, Object> fields) {
    Group group = findById(id);

    fields.forEach((field, value) -> {
      switch (field) {
        case "name":
            group.setName((String) value);
            break;
        default:
            throw new RuntimeException("Field not valid: " + field);
      }
    });

    groupRepository.save(group);
}

        public void delete(Long id) {
        Group group = findById(id);

        List<Contact> contacts = contactRepository.findByGroups_NameContainingIgnoreCase(group.getName());
        if(!contacts.isEmpty()){
            contacts.forEach((c) -> {
                c.getGroups().remove(group);
            });
        }

        groupRepository.deleteById(id);
    }
}
