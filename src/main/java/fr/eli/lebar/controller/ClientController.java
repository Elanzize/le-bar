package fr.eli.lebar.controller;


import fr.eli.lebar.dtos.ClientDto;
import fr.eli.lebar.service.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private IClientService clientService;


    // Récupérer toutes les Clients
    @GetMapping(produces = "application/json")
    public List<ClientDto> getAll() throws Exception {
        return clientService.getAll();
    }

    // La méthode renvoie finalement une liste d'objets ClientDto qui contiennent les données des Clients demandées.
    @GetMapping(produces = "application/json", value = {"/{page}/{size}/{search}","/{page}/{size}"})
    public List<ClientDto>getAll(@PathVariable("page") int page, @PathVariable("size") int size,
                                  @PathVariable(value = "search", required = false) Optional<String> search) throws Exception {

        if (search.isPresent()) {
            return clientService.getAllBy(page - 1, size, search.get());
        }
        return clientService.getAllBy(page - 1, size, "");

    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ClientDto getById(@PathVariable("id") int id) throws Exception{
        return clientService.getById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") int id) throws Exception {
        ClientDto ClientDto = clientService.getById(id);
        if(ClientDto != null){
            clientService.deleteById(id);
            return ResponseEntity.ok("Le Client avec l'id = "+ id + " est supprimer.");
        }
        throw new Exception("Le Client avec l'id = "+ id + " est pas trouver.");
    }

    @PostMapping(value = "/save", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto) throws Exception {
        ClientDto savedClient = clientService.saveOrUpadte(clientDto);
        return ResponseEntity.ok(savedClient);
    }
}
