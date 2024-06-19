package fr.eli.lebar.repository;

import fr.eli.lebar.entitie.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Page<Reservation> findAllByNumeroContaining(int numero, Pageable pageable);
}
