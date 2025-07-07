package br.gov.sp.itu.fatec.frontend.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.itu.fatec.frontend.entities.Group;
import br.gov.sp.itu.fatec.frontend.repositories.GroupRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public Group findById(Long id) {
        return groupRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Group not found"));
    }

    public Group save(Group group) {
        return groupRepository.save(group);
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
        groupRepository.deleteById(id);
    }
}
