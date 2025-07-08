package br.gov.sp.itu.fatec.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.itu.fatec.backend.entities.Photo;
import br.gov.sp.itu.fatec.backend.repositories.PhotoRepository;

@Service
public class PhotoService {
  @Autowired
  private PhotoRepository photoRepository;


  public List<Photo> getAll(){
    return this.photoRepository.findAll();
  }
}
