package br.gov.sp.itu.fatec.backend.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.itu.fatec.backend.entities.Category;
import br.gov.sp.itu.fatec.backend.entities.Contact;
import br.gov.sp.itu.fatec.backend.expections.EntityFoundException;
import br.gov.sp.itu.fatec.backend.expections.InvalidFieldException;
import br.gov.sp.itu.fatec.backend.repositories.CategoryRepository;
import br.gov.sp.itu.fatec.backend.repositories.ContactRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ContactRepository contactRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityFoundException("Category not found"));
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    public void parcialUpdate(Long id, Map<String, Object> fields) {
        Category category = findById(id);

        fields.forEach((field, value) -> {
            switch (field) {
                case "name":
                    category.setName((String) value);
                    break;
                default:
                    throw new InvalidFieldException("Field not valid: " + field);
            }
        });
        categoryRepository.save(category);
    }


    public void delete(Long id) {
        Category category = findById(id);

        List<Contact> contacts = contactRepository.findByCategories_NameIgnoreCase(category.getName());
        if(!contacts.isEmpty()){
            contacts.forEach((c) -> {
                c.getCategories().remove(category);
            });
        }

        categoryRepository.deleteById(id);
    }
}
