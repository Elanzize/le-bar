package fr.eli.lebar.mapper;

import fr.eli.lebar.dtos.BoissonDto;
import fr.eli.lebar.entitie.Boisson;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BoissonMapper {

    BoissonMapper INSTANCE = Mappers.getMapper(BoissonMapper.class);


    BoissonDto boissonToBoissonDto(Boisson boisson);

    Boisson boissonDtoToBoisson(BoissonDto boissonDto);
}
