package com.example.hotel.api.dto;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class ReservationRequest {
  @NotNull public Long clientId;
  @NotNull public Long chambreId;
  @NotNull public LocalDate dateDebut;
  @NotNull public LocalDate dateFin;
  public String preferences;
}
