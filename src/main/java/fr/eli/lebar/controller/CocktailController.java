package fr.eli.lebar.controller;


import fr.eli.lebar.dtos.CocktailDto;
import fr.eli.lebar.service.ICocktailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cocktails")
public class CocktailController {

    @Autowired
    private ICocktailService cocktailService;

    @GetMapping(produces = "application/json")
    public List<CocktailDto> getAll() throws Exception {
        return cocktailService.getAll();
    }

    @GetMapping(produces = "application/json", value = {"/{page}/{size}/{search}","/{page}/{size}"})
    public List<CocktailDto> getAll(@PathVariable("page") int page, @PathVariable("size") int size,
                                   @PathVariable(value = "search", required = false) Optional<String> search) throws Exception {

        if (search.isPresent()) {
            return cocktailService.getAllBy(page - 1, size, search.get());
        }

        return cocktailService.getAllBy(page - 1, size, "");

    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public CocktailDto getById(@PathVariable("id") int id) throws Exception{
        return cocktailService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) throws Exception {
        CocktailDto cocktailDto = cocktailService.getById(id);
        if(cocktailDto != null){
            cocktailService.deleteById(id);
            return ResponseEntity.ok("Le Cocktail avec l'id = "+ id + " est supprimer.");
        }
        throw new Exception("Le Cocktail avec l'id = "+ id + " est pas trouver.");
    }

    @PostMapping(value = "/save", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CocktailDto> save(@RequestBody CocktailDto cocktailDto) throws Exception {
        CocktailDto savedCocktail = cocktailService.saveOrUpadte(cocktailDto);
        return ResponseEntity.ok(savedCocktail);
    }
}
