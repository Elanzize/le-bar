package fr.eli.lebar.service;

import fr.eli.lebar.dtos.ReservationDto;

import java.util.List;

public interface IReservationService {
    List<ReservationDto> getAll();
    List<ReservationDto> getAllBy(int page, int size, int search) throws Exception;
    ReservationDto save(ReservationDto reservationDto) throws Exception;
    ReservationDto update(ReservationDto reservationDto) throws Exception;
    void deleteById(int id) throws Exception;
    ReservationDto getById(int id) throws Exception;
}
