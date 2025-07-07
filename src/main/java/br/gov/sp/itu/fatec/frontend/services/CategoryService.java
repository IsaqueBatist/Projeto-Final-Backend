package br.gov.sp.itu.fatec.frontend.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.itu.fatec.frontend.entities.Category;
import br.gov.sp.itu.fatec.frontend.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Category not found"));
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
                  throw new RuntimeException("Field not valid: " + field);
          }
      });

      categoryRepository.save(category);
    }


    public void delete(Long id) {
        categoryRepository.deleteById(id);
    }
}
