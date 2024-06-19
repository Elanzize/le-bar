package fr.eli.lebar.controller;

import fr.eli.lebar.dtos.ReservationDto;
import fr.eli.lebar.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private IReservationService reservationService;


    // Récupérer toutes les Reservations
    @GetMapping(produces = "application/json")
    public List<ReservationDto> getAll() throws Exception {
        return reservationService.getAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ReservationDto getById(@PathVariable("id") int id) throws Exception{
        return reservationService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) throws Exception {
        ReservationDto reservationDto = reservationService.getById(id);

        if(reservationDto != null){
            reservationService.deleteById(id);

            return ResponseEntity.ok("La Reservation avec l'id = "+ id + " est supprimer.");
        }
        throw new Exception("La Reservation avec l'id = "+ id + " est pas trouver.");
    }

    @PostMapping(value = "/save", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ReservationDto> save(@RequestBody ReservationDto reservationDto) throws Exception {
        ReservationDto savedReservation = reservationService.save(reservationDto);
        return ResponseEntity.ok(savedReservation);
    }
    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ReservationDto> update(@RequestBody ReservationDto reservationDto) throws Exception {
        ReservationDto updatedReservation = reservationService.update(reservationDto);
        return ResponseEntity.ok(updatedReservation);
    }
}
