package br.gov.sp.itu.fatec.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.itu.fatec.backend.entities.Photo;
import br.gov.sp.itu.fatec.backend.services.PhotoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;


@Tag(name = "Fotos", description = "Operaçoes de gerenciamento de Fotos")
@RestController
@RequestMapping("/photo")
public class PhotoController {
  @Autowired
  private PhotoService photoService;

  @Operation(summary = "Listar todas as fotos")
  @GetMapping()
  public List<Photo> getAll() {
      return this.photoService.getAll();
  }
  
}
