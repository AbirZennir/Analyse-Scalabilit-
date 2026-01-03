package com.example.hotel.repo;

import com.example.hotel.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {}
public interface ChambreRepository extends JpaRepository<Chambre, Long> {}
public interface ReservationRepository extends JpaRepository<Reservation, Long> {}
