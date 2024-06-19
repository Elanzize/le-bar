package fr.eli.lebar.mapper;

import fr.eli.lebar.dtos.TablsDto;
import fr.eli.lebar.entitie.Commande;
import fr.eli.lebar.entitie.Reservation;
import fr.eli.lebar.entitie.Tabls;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper
public interface TablsMapper {

    TablsMapper INSTANCE = Mappers.getMapper(TablsMapper.class);
    @Mapping(source = "reservation.id", target = "reservationId")
    @Mapping(source = "reservation.id", target = "reservationNumero")
    TablsDto tablsToTablsDto (Tabls tabls);

    Tabls tablsDtoToTabls (TablsDto tablsDto);


}
