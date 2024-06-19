package fr.eli.lebar.service;



import fr.eli.lebar.dtos.BoissonDto;

import java.util.List;

public interface IBoissonService {

    List<BoissonDto> getAll();
    List<BoissonDto> getAllBy(int page, int size, String search) throws Exception;
    BoissonDto save(BoissonDto boissonDto) throws Exception;
    BoissonDto update(BoissonDto boissonDto) throws Exception;
    void deleteById(int id) throws Exception;
    BoissonDto getById(int id) throws Exception;

}
