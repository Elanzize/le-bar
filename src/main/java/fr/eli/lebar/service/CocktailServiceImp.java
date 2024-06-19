package fr.eli.lebar.service;

import fr.eli.lebar.dtos.CocktailDto;
import fr.eli.lebar.dtos.CommandeDto;
import fr.eli.lebar.entitie.Cocktail;
import fr.eli.lebar.entitie.Commande;
import fr.eli.lebar.repository.CocktailRepository;
import fr.eli.lebar.tools.DtoTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class CocktailServiceImp implements ICocktailService{
    @Autowired
    private CocktailRepository cocktailRepository;

    @Override
    public List<CocktailDto> getAll() {
        List<Cocktail> cocktails = cocktailRepository.findAll();
        List<CocktailDto> cocktailDtos = new ArrayList<>();
        for(Cocktail c: cocktails){
            cocktailDtos.add(DtoTool.convert(c, CocktailDto.class));
        }
        return cocktailDtos;
    }


    @Override
    public List<CocktailDto> getAllBy(int page, int size, String search) throws Exception {
        List<Cocktail> cocktails = cocktailRepository.findAllByNameContaining(search, PageRequest.of(page, size)).getContent();
        List<CocktailDto> result = new ArrayList<>();
        for (Cocktail c : cocktails) {
            result.add(DtoTool.convert(c, CocktailDto.class));
        }
        return result;
    }

    @Override
    public CocktailDto saveOrUpadte (CocktailDto CocktailDto) throws Exception {
        Cocktail cocktail = DtoTool.convert(CocktailDto, Cocktail.class);
        Cocktail savedCocktail = cocktailRepository.saveAndFlush(cocktail);
        return DtoTool.convert(savedCocktail, CocktailDto.class);
    }

    @Override
    public void deleteById ( int id) throws Exception {
        cocktailRepository.deleteById(id);
    }

    @Override
    public CocktailDto getById ( int id) throws Exception {
        Optional<Cocktail> optional= cocktailRepository.findById(id);
        if(optional.isPresent()){
            Cocktail cocktail = optional.get();
            return DtoTool.convert(cocktail, CocktailDto.class);
        }
        return null;
    }
}
