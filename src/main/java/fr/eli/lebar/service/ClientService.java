package fr.eli.lebar.service;

import fr.eli.lebar.dtos.ClientDto;
import fr.eli.lebar.entitie.Client;
import fr.eli.lebar.repository.ClientRepository;
import fr.eli.lebar.tools.DtoTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService implements IClientService {
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public List<ClientDto> getAll() {
        List<Client> clients = clientRepository.findAll();
        List<ClientDto> clientDtos = new ArrayList<>();
        for (Client client : clients) {
            ClientDto clientDto = DtoTool.convert(client, ClientDto.class);
            clientDtos.add(clientDto);
        }
        return clientDtos;
    }

    @Override
    public List<ClientDto> getAllBy(int page, int size, String search) throws Exception {
        List<ClientDto> result = new ArrayList<>();
        List<Client> clients = clientRepository.findAllByNomContaining(search, PageRequest.of(page, size)).getContent();
        for (Client c : clients) {
            result.add(DtoTool.convert(c, ClientDto.class));
        }
        return result;
    }

    @Override
    public ClientDto saveOrUpadte (ClientDto ClientDto) throws Exception {
        Client client = DtoTool.convert(ClientDto, Client.class);
        Client savedClient = clientRepository.saveAndFlush(client);
        return DtoTool.convert(savedClient, ClientDto.class);
    }

    @Override
    public void deleteById ( int id) throws Exception {
        clientRepository.deleteById(id);
    }

    @Override
    public ClientDto getById ( int id) throws Exception {
        Optional<Client> optional= clientRepository.findById(id);
        if(optional.isPresent()){
            Client client = optional.get();
            return DtoTool.convert(client, ClientDto.class);
        }
        return null;
    }
}
