package com.example.hotel.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "clients")
public class Client {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotBlank private String nom;
  @NotBlank private String prenom;

  @Email @Column(unique = true, nullable = false)
  private String email;

  private String telephone;

 
}
