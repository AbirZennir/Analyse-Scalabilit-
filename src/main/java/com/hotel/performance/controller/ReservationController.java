package com.example.hotel.api;

import com.example.hotel.api.dto.ReservationRequest;
import com.example.hotel.domain.Reservation;
import com.example.hotel.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

  private final ReservationService service;
  public ReservationController(ReservationService service) { this.service = service; }

  @PostMapping
  public Reservation create(@Valid @RequestBody ReservationRequest req) {
    return service.create(req);
  }

  @GetMapping("/{id}")
  public Reservation get(@PathVariable Long id) { return service.get(id); }

  @PutMapping("/{id}")
  public Reservation update(@PathVariable Long id, @Valid @RequestBody ReservationRequest req) {
    return service.update(id, req);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Long id) { service.delete(id); }
}
