package br.gov.sp.itu.fatec.frontend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.itu.fatec.frontend.entities.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{
  
}
