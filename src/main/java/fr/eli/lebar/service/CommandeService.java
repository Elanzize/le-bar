package fr.eli.lebar.service;

import fr.eli.lebar.dtos.CommandeDto;
import fr.eli.lebar.entitie.Commande;
import fr.eli.lebar.mapper.CommandeMapper;
import fr.eli.lebar.repository.CommandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CommandeService implements ICommandeService{

    @Autowired
    private CommandeRepository commandeRepository;
    private final CommandeMapper mapper = CommandeMapper.INSTANCE;
    @Override
    public List<CommandeDto> getAll() {
        List<Commande> commandes = commandeRepository.findAll();
        List<CommandeDto> commandeDtos = new ArrayList<>();
        for (Commande commande : commandes) {
            CommandeDto commandeDto = mapper.commandeToCommandeDto(commande);
            commandeDtos.add(commandeDto);
        }
        return commandeDtos;
    }

    @Override
    public CommandeDto save (CommandeDto commandeDto) throws Exception {
        Commande commande = mapper.commandeDtoToCommande(commandeDto);
        Commande savedCommade = commandeRepository.saveAndFlush(commande);
        return mapper.commandeToCommandeDto(savedCommade);
    }
    @Override
    public CommandeDto update (CommandeDto commandeDto) throws Exception {
        Commande commande = mapper.commandeDtoToCommande(commandeDto);
        Commande updatedCommande = commandeRepository.saveAndFlush(commande);
        return mapper.commandeToCommandeDto(updatedCommande);
    }

    @Override
    public void deleteById ( int id) throws Exception {
        commandeRepository.deleteById(id);
    }

    @Override
    public CommandeDto getById ( int id) throws Exception {
        Optional<Commande> optional= commandeRepository.findById(id);
        if(optional.isPresent()){
            Commande commande = optional.get();
            return mapper.commandeToCommandeDto(commande);
        }
        return null;
    }

    
}
