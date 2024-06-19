package fr.eli.lebar.service;

import fr.eli.lebar.dtos.ReservationDto;
import fr.eli.lebar.entitie.Reservation;
import fr.eli.lebar.entitie.Tabls;
import fr.eli.lebar.enums.Disponible;
import fr.eli.lebar.mapper.ReservationMapper;
import fr.eli.lebar.repository.ReservationRepository;
import fr.eli.lebar.repository.TablsRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ReservationService implements IReservationService{
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private TablsRepository tablsRepository;
    private final ReservationMapper mapper = ReservationMapper.INSTANCE;

    @Override
    public List<ReservationDto> getAll() {
        List<Reservation> reservations = reservationRepository.findAll();
        List<ReservationDto> reservationDtos = new ArrayList<>();
        for (Reservation reservation : reservations) {
            ReservationDto ReservationDto = mapper.reservationToReservationDto(reservation);
            reservationDtos.add(ReservationDto);
        }

        return reservationDtos;
    }

    @Override
    public List<ReservationDto> getAllBy(int page, int size, int search) throws Exception {
        List<ReservationDto> result = new ArrayList<>();
        List<Reservation> reservations = reservationRepository.findAllByNumeroContaining(search, PageRequest.of(page, size)).getContent();
        for (Reservation r : reservations) {
            ReservationDto reservationDto = mapper.reservationToReservationDto(r);
            result.add(reservationDto);
        }
        return result;
    }
    @Override
    public ReservationDto save(ReservationDto reservationDto) throws Exception {
        Reservation reservation = mapper.reservationDtoToReservation(reservationDto);
        Reservation savedReservation = reservationRepository.saveAndFlush(reservation);
        Long tablsId = savedReservation.getTabls().getId();
        // Changez l'état de disponibilité de cette table en "RESERVEE"
        tablsRepository.updateDisponibleById(tablsId, Disponible.RESERVEE);

        return mapper.reservationToReservationDto(savedReservation);
    }
    @Override
    public ReservationDto update(ReservationDto reservationDto) throws Exception {
        Reservation reservation = mapper.reservationDtoToReservation((reservationDto));
        Reservation savedReservation = reservationRepository.saveAndFlush(reservation);
        Tabls tabls = savedReservation.getTabls();

        // Changez l'état de disponibilité de cette table en "RESERVEE"
        tabls.setDisponible(Disponible.RESERVEE);

        // Enregistrez à nouveau la table mise à jour dans la base de données
        tablsRepository.save(tabls);
        return mapper.reservationToReservationDto(savedReservation);
    }


    @Override
    public void deleteById ( int id) throws Exception {
        reservationRepository.deleteById(id);
    }

    @Override
    public ReservationDto getById ( int id) throws Exception {
        Optional<Reservation> optional= reservationRepository.findById(id);
        if(optional.isPresent()){
            Reservation reservation = optional.get();
            return mapper.reservationToReservationDto(reservation);
        }

        return null;
    }
}
