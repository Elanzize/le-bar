package fr.eli.lebar.service;

import fr.eli.lebar.dtos.CommandeDto;

import java.util.List;

public interface ICommandeService {
    List<CommandeDto> getAll();
    CommandeDto save(CommandeDto commandeDto) throws Exception;
    CommandeDto update(CommandeDto commandeDto) throws Exception;
    void deleteById(int id) throws Exception;
    CommandeDto getById(int id) throws Exception;
}
