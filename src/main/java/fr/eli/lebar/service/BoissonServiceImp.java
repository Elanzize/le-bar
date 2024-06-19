package fr.eli.lebar.service;

import fr.eli.lebar.dtos.BoissonDto;
import fr.eli.lebar.entitie.Boisson;
import fr.eli.lebar.mapper.BoissonMapper;
import fr.eli.lebar.repository.BoissonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoissonServiceImp implements IBoissonService {

    @Autowired
    private BoissonRepository boissonRepository;

    private final BoissonMapper mapper = BoissonMapper.INSTANCE;

    @Override
    public List<BoissonDto> getAll() {
        List<Boisson> boissons = boissonRepository.findAll();  // Récupérer toutes les boissons depuis le repository
        List<BoissonDto> boissonDtos = new ArrayList<>();  // Initialiser une liste pour stocker les DTOs de boissons
        for (Boisson boisson : boissons) {
            BoissonDto boissonDto = mapper.boissonToBoissonDto(boisson); // Convertir la boisson en DTO
            boissonDtos.add(boissonDto);
        }
        return boissonDtos;
    }

    @Override
    public List<BoissonDto> getAllBy(int page, int size, String search) {
        List<Boisson> boissons = boissonRepository.findAllByNameContaining(search, PageRequest.of(page, size)).getContent();
        List<BoissonDto> result = new ArrayList<>();
        for (Boisson boisson : boissons) {
            BoissonDto boissonDto = mapper.boissonToBoissonDto(boisson);
            result.add(boissonDto);
        }
        return result;
    }

    @Override
    public BoissonDto save(BoissonDto boissonDto) {
        Boisson boisson = mapper.boissonDtoToBoisson(boissonDto);
        Boisson savedBoisson = boissonRepository.saveAndFlush(boisson);
        return mapper.boissonToBoissonDto(savedBoisson);
    }

    @Override
    public BoissonDto update(BoissonDto boissonDto) {
        Boisson boisson = mapper.boissonDtoToBoisson(boissonDto);
        Boisson updatedBoisson = boissonRepository.saveAndFlush(boisson);
        return mapper.boissonToBoissonDto(updatedBoisson);
    }

    @Override
    public void deleteById(int id) {
        boissonRepository.deleteById(id);
    }

    @Override
    public BoissonDto getById(int id) {
        Optional<Boisson> optional = boissonRepository.findById(id);
        if (optional.isPresent()) {
            Boisson boisson = optional.get();
            return mapper.boissonToBoissonDto(boisson);
        }
        return null;
    }
}
