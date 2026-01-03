package com.example.hotel.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "chambres")
public class Chambre {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String type;
  private BigDecimal prix;
  private boolean disponible = true;

}
