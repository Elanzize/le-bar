package fr.eli.lebar.service;

import fr.eli.lebar.dtos.ClientDto;

import java.util.List;

public interface IClientService {
    List<ClientDto> getAll();
    List<ClientDto> getAllBy(int page, int size, String search) throws Exception;
    ClientDto saveOrUpadte(ClientDto clientDto) throws Exception;
    void deleteById(int id) throws Exception;
    ClientDto getById(int id) throws Exception;
}
