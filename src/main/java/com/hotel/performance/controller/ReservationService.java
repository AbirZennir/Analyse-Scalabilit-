package com.example.hotel.service;

import com.example.hotel.api.dto.ReservationRequest;
import com.example.hotel.domain.*;
import com.example.hotel.repo.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservationService {
  private final ClientRepository clientRepo;
  private final ChambreRepository chambreRepo;
  private final ReservationRepository reservationRepo;

  public ReservationService(ClientRepository c, ChambreRepository ch, ReservationRepository r) {
    this.clientRepo = c; this.chambreRepo = ch; this.reservationRepo = r;
  }

  @Transactional
  public Reservation create(ReservationRequest req) {
    Client client = clientRepo.findById(req.clientId).orElseThrow();
    Chambre chambre = chambreRepo.findById(req.chambreId).orElseThrow();

    Reservation res = new Reservation();
    res.setClient(client);
    res.setChambre(chambre);
    res.setDateDebut(req.dateDebut);
    res.setDateFin(req.dateFin);
    res.setPreferences(req.preferences);

    return reservationRepo.save(res);
  }

  public Reservation get(Long id) {
    return reservationRepo.findById(id).orElseThrow();
  }

  @Transactional
  public Reservation update(Long id, ReservationRequest req) {
    Reservation res = get(id);
    res.setDateDebut(req.dateDebut);
    res.setDateFin(req.dateFin);
    res.setPreferences(req.preferences);
    if (req.clientId != null) res.setClient(clientRepo.findById(req.clientId).orElseThrow());
    if (req.chambreId != null) res.setChambre(chambreRepo.findById(req.chambreId).orElseThrow());
    return res;
  }

  public void delete(Long id) {
    reservationRepo.deleteById(id);
  }
}
