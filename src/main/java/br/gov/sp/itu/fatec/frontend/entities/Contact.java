package br.gov.sp.itu.fatec.frontend.entities;

import java.time.LocalDate;
import java.util.List;

public class Contact {
  private Long id;
  private String firstname;
  private String lastname;
  private List<Email> emails;
  private List<Phone> phones;
  private List<Address> addresses;
  private LocalDate birthDate;
  private List<Group> groups;
  private String note;
  private boolean isFavorite;
  private List<Category> categories;
}
