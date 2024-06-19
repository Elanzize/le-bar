package fr.eli.lebar.mapper;

import fr.eli.lebar.dtos.ReservationDto;
import fr.eli.lebar.entitie.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ReservationMapper {

    ReservationMapper INSTANCE = Mappers.getMapper(ReservationMapper.class);
    @Mapping(source = "employe.id", target = "employeId")
    @Mapping(source = "tabls.id", target = "tablsId")
    @Mapping(source = "employe.nom", target = "employeNom")
    @Mapping(source = "employe.prenom", target = "employePrenom")
    ReservationDto reservationToReservationDto(Reservation reservation);
    @Mapping(source = "employeId", target = "employe.id")
    @Mapping(source = "tablsId", target = "tabls.id")
    @Mapping(source = "employeNom", target = "employe.nom")
    @Mapping(source = "employePrenom", target = "employe.prenom")
    Reservation reservationDtoToReservation(ReservationDto reservationDto);

}