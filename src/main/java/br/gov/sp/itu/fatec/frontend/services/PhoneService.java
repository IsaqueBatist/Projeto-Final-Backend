package br.gov.sp.itu.fatec.frontend.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.itu.fatec.frontend.entities.Phone;
import br.gov.sp.itu.fatec.frontend.repositories.PhoneRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    public List<Phone> findAll() {
        return phoneRepository.findAll();
    }

    public Phone findById(Long id) {
        return phoneRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Phone not found"));
    }

    public Phone save(Phone phone) {
        return phoneRepository.save(phone);
    }

    public void parcialUpdate(Long id, Map<String, Object> fields) {
      Phone phone = findById(id);

      fields.forEach((field, value) -> {
        switch (field) {
          case "label":
              phone.setLabel((String) value);
              break;
          case "phoneNumber":
              phone.setPhoneNumber((String) value);
              break;
          default:
              throw new RuntimeException("Field not valid: " + field);
        }
      });

      phoneRepository.save(phone);
    }


    public void delete(Long id) {
        phoneRepository.deleteById(id);
    }
}
