package br.gov.sp.itu.fatec.frontend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.itu.fatec.frontend.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
  
}
