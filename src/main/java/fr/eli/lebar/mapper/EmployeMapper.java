package fr.eli.lebar.mapper;

import fr.eli.lebar.dtos.EmployeDto;
import fr.eli.lebar.entitie.Commande;
import fr.eli.lebar.entitie.Employe;
import fr.eli.lebar.entitie.Reservation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface EmployeMapper {

    EmployeMapper INSTANCE = Mappers.getMapper(EmployeMapper.class);

    @Mapping(source = "commandes", target = "commandeIds", qualifiedByName = "mapCommandeIds")
    @Mapping(source = "commandes", target = "commandeNumeros", qualifiedByName = "mapCommandeNumeros")
    @Mapping(source = "commandes", target = "commandeTotals", qualifiedByName = "mapCommandeTotals")
    @Mapping(source = "reservations", target = "reservationIds", qualifiedByName = "mapReservationIds")
    @Mapping(source = "reservations", target = "reservationNumeros", qualifiedByName = "mapReservationNumeros")
    @Mapping(source = "reservations", target = "reservationDates", qualifiedByName = "mapReservationDates")
    @Mapping(source = "reservations", target = "reservationNoms", qualifiedByName = "mapReservationNoms")
    @Mapping(source = "reservations", target = "reservationPrenoms", qualifiedByName = "mapReservationPrenoms")
    EmployeDto employeToEmployeDto(Employe employe);

    Employe employeDtoToEmploye(EmployeDto employeDto);

    @Named("mapCommandeIds")
    default List<Long> mapCommandeIds(List<Commande> commandes) {
        return commandes.stream()
                .map(Commande::getId)
                .collect(Collectors.toList());
    }

    @Named("mapCommandeNumeros")
    default List<Integer> mapCommandeNumeros(List<Commande> commandes) {
        return commandes.stream()
                .map(Commande::getNumero)
                .collect(Collectors.toList());
    }

    @Named("mapCommandeTotals")
    default List<Double> mapCommandeTotals(List<Commande> commandes) {
        return commandes.stream()
                .map(Commande::getTotal)
                .collect(Collectors.toList());
    }
    @Named("mapReservationIds")
    default List<Long> mapReservationIds(List<Reservation> reservations) {
        return reservations.stream()
                .map(Reservation::getId)
                .collect(Collectors.toList());
    }
    @Named("mapReservationNumeros")
    default List<Integer> mapReservationNumeros(List<Reservation> reservations) {
        return reservations.stream()
                .map(Reservation::getNumero)
                .collect(Collectors.toList());
    }
    @Named("mapReservationDates")
    default List<Date> mapReservationDates(List<Reservation> reservations) {
        return reservations.stream()
                .map(Reservation::getDateReservation)
                .collect(Collectors.toList());
    }
    @Named("mapReservationNoms")
    default List<String> mapReservationNoms(List<Reservation> reservations) {
        return reservations.stream()
                .map(Reservation::getNom)
                .collect(Collectors.toList());
    }
    @Named("mapReservationPrenoms")
    default List<String> mapReservationPrenoms(List<Reservation> reservations) {
        return reservations.stream()
                .map(Reservation::getPrenom)
                .collect(Collectors.toList());
    }
}
