package com.example.hotel.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reservations")
public class Reservation {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(optional = false) @JoinColumn(name = "client_id")
  private Client client;

  @ManyToOne(optional = false) @JoinColumn(name = "chambre_id")
  private Chambre chambre;

  @Column(name = "date_debut", nullable = false)
  private LocalDate dateDebut;

  @Column(name = "date_fin", nullable = false)
  private LocalDate dateFin;

  @Column(columnDefinition = "TEXT")
  private String preferences;

}
