package br.gov.sp.itu.fatec.frontend.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.itu.fatec.frontend.entities.Contact;
import br.gov.sp.itu.fatec.frontend.repositories.ContactRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contact not found"));
    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);
    }

    public void parcialUpdate(Long id, Map<String, Object> fields) {
      Contact contact = findById(id);

      fields.forEach((field, value) -> {
        switch (field) {
          case "firstname":
              contact.setFirstname((String) value);
              break;
          case "lastname":
              contact.setLastname((String) value);
              break;
          case "birthDate":
              contact.setBirthDate(LocalDate.parse((String) value));
              break;
          case "isFavorite":
              contact.setFavorite((Boolean) value);
              break;
          case "note":
              contact.setNote((String) value);
              break;
          default:
              throw new RuntimeException("Field not valid: " + field);
        }
      });

      contactRepository.save(contact);
    }


    public void delete(Long id) {
        contactRepository.deleteById(id);
    }
}
