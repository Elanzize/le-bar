package fr.eli.lebar.service;



import fr.eli.lebar.dtos.CocktailDto;

import java.util.List;

public interface ICocktailService {

    List<CocktailDto> getAll();
    List<CocktailDto> getAllBy(int page, int size, String search) throws Exception;
    CocktailDto saveOrUpadte(CocktailDto cocktailDto) throws Exception;
    void deleteById(int id) throws Exception;
    CocktailDto getById(int id) throws Exception;
}
