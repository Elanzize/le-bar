package fr.eli.lebar.controller;

import fr.eli.lebar.dtos.CommandeDto;
import fr.eli.lebar.service.ICommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/commandes")
public class CommandeController {
    @Autowired
    private ICommandeService commandeService;


    // Récupérer toutes les Commandes
    @GetMapping(produces = "application/json")
    public List<CommandeDto> getAll() throws Exception {
        return commandeService.getAll();
    }
    // Récupérer une Commande en foction de sont id
    @GetMapping(value = "/{id}", produces = "application/json")
    public CommandeDto getById(@PathVariable("id") int id) throws Exception{
        return commandeService.getById(id);
    }
    // supprimer une commande
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) throws Exception {
        CommandeDto CommandeDto = commandeService.getById(id);
        if(CommandeDto != null){
            commandeService.deleteById(id);
            return ResponseEntity.ok("La Commande avec l'id = "+ id + " est supprimer.");
        }
        throw new Exception("La Commande avec l'id = "+ id + " est pas trouver.");
    }
    // Ajouter une commande
    @PostMapping(value = "/save", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CommandeDto> save(@RequestBody CommandeDto commandeDto) throws Exception {
        CommandeDto savedCommande = commandeService.save(commandeDto);
        return ResponseEntity.ok(savedCommande);
    }
    // Mettre à jour une commande
    @PutMapping(value = "/update", produces = "application/json", consumes = "application/json")
    public ResponseEntity<CommandeDto> update(@RequestBody CommandeDto commandeDto) throws Exception {
        CommandeDto updateCommande = commandeService.save(commandeDto);
        return ResponseEntity.ok(updateCommande);
    }
}
