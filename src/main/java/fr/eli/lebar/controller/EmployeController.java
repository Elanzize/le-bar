package fr.eli.lebar.controller;

import fr.eli.lebar.dtos.EmployeDto;
import fr.eli.lebar.entitie.Commande;
import fr.eli.lebar.service.IEmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employes")
public class EmployeController {
    @Autowired
    private IEmployeService employeService;


    // Récupérer toutes les Employes
    @GetMapping(produces = "application/json")
    public List<EmployeDto> getAll() throws Exception {
        return employeService.getAll();
    }

    // La méthode renvoie finalement une liste d'objets EmployeDto qui contiennent les données des Employes demandées.
    @GetMapping(produces = "application/json", value = {"/{page}/{size}/{search}","/{page}/{size}"})
    public List<EmployeDto>getAll(@PathVariable("page") int page, @PathVariable("size") int size,
                                 @PathVariable(value = "search", required = false) Optional<String> search) throws Exception {

        if (search.isPresent()) {
            return employeService.getAllBy(page - 1, size, search.get());
        }
        return employeService.getAllBy(page - 1, size, "");

    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public EmployeDto getById(@PathVariable("id") int id) throws Exception{
        return employeService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) throws Exception {
        EmployeDto employeDto = employeService.getById(id);

        if(employeDto != null){
            employeService.deleteById(id);

            return ResponseEntity.ok("La Employe avec l'id = "+ id + " est supprimer.");
        }
        throw new Exception("La Employe avec l'id = "+ id + " est pas trouver.");
    }

    @PostMapping(value = "/save", produces = "application/json", consumes = "application/json")
    public ResponseEntity<EmployeDto> save(@RequestBody EmployeDto employeDto) throws Exception {
        EmployeDto savedEmploye = employeService.save(employeDto);
        return ResponseEntity.ok(savedEmploye);
    }

    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<EmployeDto> update(@RequestBody EmployeDto employeDto) throws Exception {
        EmployeDto updateEmploye = employeService.update(employeDto);
        return ResponseEntity.ok(updateEmploye);
    }
}
