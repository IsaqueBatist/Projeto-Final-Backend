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
@Table(name = "TBL_ADDRESSES")
public class Address {
  private Long id;
  private String number;
  private String complement;
  private String neighborhood;
  private String city;
  private String state;
  private String country;
  private String postalCode;
}
