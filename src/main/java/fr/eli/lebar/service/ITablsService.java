package fr.eli.lebar.service;

import fr.eli.lebar.dtos.TablsDto;

import java.util.List;

public interface ITablsService {
    List<TablsDto> getAll();
    List<TablsDto> getAllBy(int page, int size, int search) throws Exception;
    TablsDto save(TablsDto tablsDto) throws Exception;
    TablsDto update(TablsDto tablsDto) throws Exception;
    void deleteById(int id) throws Exception;
    TablsDto getById(int id) throws Exception;
}
