package br.gov.sp.itu.fatec.backend.services;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.tomcat.util.http.fileupload.InvalidFileNameException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.gov.sp.itu.fatec.backend.entities.Address;
import br.gov.sp.itu.fatec.backend.entities.Category;
import br.gov.sp.itu.fatec.backend.entities.Contact;
import br.gov.sp.itu.fatec.backend.entities.Email;
import br.gov.sp.itu.fatec.backend.entities.Group;
import br.gov.sp.itu.fatec.backend.entities.Phone;
import br.gov.sp.itu.fatec.backend.expections.EntityFoundException;
import br.gov.sp.itu.fatec.backend.repositories.AddressRepository;
import br.gov.sp.itu.fatec.backend.repositories.CategoryRepository;
import br.gov.sp.itu.fatec.backend.repositories.ContactRepository;
import br.gov.sp.itu.fatec.backend.repositories.EmailRepository;
import br.gov.sp.itu.fatec.backend.repositories.GroupRepository;
import br.gov.sp.itu.fatec.backend.repositories.PhoneRepository;

@Service
public class ContactService {
    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private EmailRepository emailRepository;
    
    @Autowired
    private PhoneRepository phoneRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;
    
    @Autowired
    private GroupRepository groupRepository;

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
