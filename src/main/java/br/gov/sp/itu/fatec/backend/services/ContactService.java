package br.gov.sp.itu.fatec.backend.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.http.fileupload.InvalidFileNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.itu.fatec.backend.entities.Contact;
import br.gov.sp.itu.fatec.backend.expections.EntityFoundException;
import br.gov.sp.itu.fatec.backend.repositories.ContactRepository;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    public List<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new EntityFoundException("Contact not found"));
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
                new InvalidFileNameException("Field not valid ", field);
        }
        });

        contactRepository.save(contact);
    }


    public void delete(Long id) {
        contactRepository.deleteById(id);
    }

    public List<Contact> findByNameContainingIgnoreCase(String name) {
        return contactRepository.findByFirstnameContainingIgnoreCase(name);
    }

    public List<Contact> findByPhonesNumberContainingIgnoreCase(String partialNumber) {
        return contactRepository.findByPhones_PhoneNumberContainingIgnoreCase(partialNumber);
    }

    public List<Contact> findByEmailsEmailContainingIgnoreCase(String partialAddress) {
        return contactRepository.findByEmails_EmailContainingIgnoreCase(partialAddress);
    }

    public List<Contact> findByFavorite(boolean favorite) {
        return contactRepository.findByIsFavorite(favorite);
    }

    public List<Contact> findByCategoriesNameIgnoreCase(String name) {
        return contactRepository.findByCategories_NameIgnoreCase(name);
    }

    public List<Contact> findByGroupNameContainingIgnoreCase(String groupName) {
        return contactRepository.findByGroups_NameContainingIgnoreCase(groupName);
    }
}
