package br.gov.sp.itu.fatec.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.itu.fatec.backend.entities.Email;

public interface EmailRepository extends JpaRepository<Email, Long>{
  
}
