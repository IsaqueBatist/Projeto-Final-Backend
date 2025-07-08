package br.gov.sp.itu.fatec.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.itu.fatec.backend.entities.Contact;


public interface ContactRepository extends JpaRepository<Contact, Long>{

    List<Contact> findByFirstnameContainingIgnoreCase(String name);

    List<Contact> findByPhones_PhoneNumberContainingIgnoreCase(String partialNumber);

    List<Contact> findByEmails_EmailContainingIgnoreCase(String partialAddress);

    List<Contact> findByIsFavorite(boolean favorite);

    List<Contact> findByCategories_NameIgnoreCase(String name);

    List<Contact> findByGroups_NameContainingIgnoreCase(String name);

}
