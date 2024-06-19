package fr.eli.lebar.controller;

import fr.eli.lebar.dtos.TablsDto;
import fr.eli.lebar.service.ITablsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tablss")
public class TablsController {
    @Autowired
    private ITablsService tablsService;


    // Récupérer toutes les Tables
    @GetMapping(produces = "application/json")
    public List<TablsDto> getAll() throws Exception {
        return tablsService.getAll();
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public TablsDto getById(@PathVariable("id") int id) throws Exception{
        return tablsService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) throws Exception {
        TablsDto tablsDto = tablsService.getById(id);
        if(tablsDto != null){
            tablsService.deleteById(id);
            return ResponseEntity.ok("La Table avec l'id = "+ id + " est supprimer.");
        }
        throw new Exception("La Table avec l'id = "+ id + " est pas trouver.");
    }

    @PostMapping(value = "/save", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TablsDto> save(@RequestBody TablsDto tablsDto) throws Exception {
        TablsDto savedTabls = tablsService.save(tablsDto);
        return ResponseEntity.ok(savedTabls);
    }

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<TablsDto> update(@RequestBody TablsDto tablsDto) throws Exception {
        TablsDto updatedTabls = tablsService.update(tablsDto);
        return ResponseEntity.ok(updatedTabls);
    }
}
