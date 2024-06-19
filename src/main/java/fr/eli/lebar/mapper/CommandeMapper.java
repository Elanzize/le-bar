package fr.eli.lebar.mapper;

import fr.eli.lebar.dtos.CommandeDto;
import fr.eli.lebar.entitie.Commande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
@Mapper
public interface CommandeMapper {

    CommandeMapper INSTANCE = Mappers.getMapper(CommandeMapper.class);
    @Mapping(source = "employe.id", target = "employeId")
    @Mapping(source = "tabls.id", target = "tablsId")
    @Mapping(source = "employe.nom", target = "employeNom")
    @Mapping(source = "employe.prenom", target = "employePrenom")
    CommandeDto commandeToCommandeDto (Commande commande);
    @Mapping(source = "employeId", target = "employe.id")
    @Mapping(source = "tablsId", target = "tabls.id")
    @Mapping(source = "employeNom", target = "employe.nom")
    @Mapping(source = "employePrenom", target = "employe.prenom")
    Commande commandeDtoToCommande (CommandeDto commandeDto);
}
