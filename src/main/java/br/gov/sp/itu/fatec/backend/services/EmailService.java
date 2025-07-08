package br.gov.sp.itu.fatec.backend.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.itu.fatec.backend.entities.Email;
import br.gov.sp.itu.fatec.backend.expections.EntityFoundException;
import br.gov.sp.itu.fatec.backend.repositories.EmailRepository;

@Service
public class EmailService {
  @Autowired
  private EmailRepository emailRepository;

  //Pegar email por id
  public Email findById(Long id){
    return emailRepository.findById(id).orElseThrow(() -> new EntityFoundException("Email not found"));
  }

  public List<Email> findAll(){
    return emailRepository.findAll();
  }

  //Criar um novo email
  public void createEmail(Email email){
    emailRepository.save(email);
  }

  public Email save(Email email){
    return emailRepository.save(email);
  }

  //Editar um email
  public void parcialUpdate(Long id, Map<String, Object> fields){
    Email email = findById(id);

    fields.forEach((field, value) -> {
      switch (field) {
          case "label":
              email.setLabel((String) value);
              break;
          case "email":
              email.setEmail((String) value);
              break;
          default:
              throw new RuntimeException("field not valid");
      }
    });
    this.emailRepository.save(email);
  }

  public void delete(Long id){
    findById(id);
    this.emailRepository.deleteById(id);
  }
}
