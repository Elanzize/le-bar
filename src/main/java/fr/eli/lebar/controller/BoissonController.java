package fr.eli.lebar.controller;

import fr.eli.lebar.dtos.BoissonDto;
import fr.eli.lebar.service.IBoissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/boissons")
public class BoissonController {

    @Autowired
    private IBoissonService boissonService;


    // Récupérer toutes les boissons
    @GetMapping(produces = "application/json")
    public List<BoissonDto> getAll() throws Exception {
        return boissonService.getAll();
    }

    // La méthode renvoie finalement une liste d'objets BoissonDto qui contiennent les données des boissons demandées.
    @GetMapping(produces = "application/json", value = {"/{page}/{size}/{search}","/{page}/{size}"})
    public List<BoissonDto>getAll(@PathVariable("page") int page, @PathVariable("size") int size,
                                  @PathVariable(value = "search", required = false) Optional<String> search) throws Exception {

        /*
         * Page commence à 1
         */
        if (search.isPresent()) {
            return boissonService.getAllBy(page - 1, size, search.get());
        }

        return boissonService.getAllBy(page - 1, size, "");

    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public BoissonDto getById(@PathVariable("id") int id) throws Exception{
        return boissonService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) throws Exception {
        BoissonDto boissonDto = boissonService.getById(id);
        if(boissonDto != null){
            boissonService.deleteById(id);
            return ResponseEntity.ok("La Boisson avec l'id = "+ id + " est supprimer.");
        }
        throw new Exception("La Boisson avec l'id = "+ id + " est pas trouver.");
    }

    @PostMapping(value = "/save", produces = "application/json", consumes = "application/json")
    public ResponseEntity<BoissonDto> save(@RequestBody BoissonDto boissonDto) throws Exception {
        BoissonDto savedBoisson = boissonService.save(boissonDto);
        return ResponseEntity.ok(savedBoisson);
    }

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<BoissonDto> update(@RequestBody BoissonDto boissonDto) throws Exception {
        BoissonDto updateBoisson = boissonService.update(boissonDto);
        return ResponseEntity.ok(updateBoisson);
    }
}
