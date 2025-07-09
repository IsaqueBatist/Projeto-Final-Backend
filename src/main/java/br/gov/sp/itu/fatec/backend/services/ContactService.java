package br.gov.sp.itu.fatec.backend.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.gov.sp.itu.fatec.backend.entities.Address;
import br.gov.sp.itu.fatec.backend.entities.Contact;
import br.gov.sp.itu.fatec.backend.entities.Email;
import br.gov.sp.itu.fatec.backend.entities.Phone;
import br.gov.sp.itu.fatec.backend.expections.EntityFoundException;

import br.gov.sp.itu.fatec.backend.repositories.ContactRepository;
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
                .orElseThrow(() -> new EntityFoundException("Contact not found"));
    }

    public Contact save(Contact contact) {

        return contactRepository.save(contact);
    }

public Contact update(Long id, Contact updatedContact, MultipartFile photo) throws IOException {
    Contact existing = contactRepository.findById(id)
        .orElseThrow(() -> new EntityNotFoundException("Contato não encontrado"));

    existing.setFirstname(updatedContact.getFirstname());
    existing.setLastname(updatedContact.getLastname());
    existing.setFavorite(updatedContact.isFavorite());
    existing.setNote(updatedContact.getNote());
    existing.setBirthDate(updatedContact.getBirthDate());
     // Endereços: limpa e adiciona manualmente
    existing.getAddresses().clear();
    for (Address addr : updatedContact.getAddresses()) {
        existing.getAddresses().add(addr);
    }

    // Telefones
    existing.getPhones().clear();
    for (Phone phone : updatedContact.getPhones()) {
        existing.getPhones().add(phone);
    }

    // E-mails
    existing.getEmails().clear();
    for (Email email : updatedContact.getEmails()) {
        existing.getEmails().add(email);
    }

    existing.setGroups(updatedContact.getGroups());
    existing.setCategories(updatedContact.getCategories());


    if (photo != null && !photo.isEmpty()) {
        existing.setPhoto(photo.getBytes());
    }

    return contactRepository.save(existing);
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
