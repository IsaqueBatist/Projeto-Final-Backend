package br.gov.sp.itu.fatec.frontend.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@EqualsAndHashCode(of = "id")
@Table(name = "TBL_EMAILS")
public class Email {
  private Long id;
  private String label;
  private String email;
}