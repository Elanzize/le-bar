package fr.eli.lebar.service;

import fr.eli.lebar.dtos.TablsDto;
import fr.eli.lebar.entitie.Tabls;
import fr.eli.lebar.mapper.TablsMapper;
import fr.eli.lebar.repository.TablsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TablsService implements ITablsService{
    @Autowired
    private TablsRepository tablsRepository;
    private final TablsMapper mapper = TablsMapper.INSTANCE;

    @Override
    public List<TablsDto> getAll() {
        List<Tabls> tablss = tablsRepository.findAll();
        List<TablsDto> tablsDtos = new ArrayList<>();
        for (Tabls tabls : tablss) {
            TablsDto TablsDto = mapper.tablsToTablsDto(tabls);
            tablsDtos.add(TablsDto);
        }

        return tablsDtos;
    }

    @Override
    public List<TablsDto> getAllBy(int page, int size, int search) throws Exception {
        List<TablsDto> result = new ArrayList<>();
        List<Tabls> tablss = tablsRepository.findAllByNumeroContaining(search, PageRequest.of(page, size)).getContent();
        for (Tabls t : tablss) {
            TablsDto tablsDto = mapper.tablsToTablsDto(t);
            result.add(tablsDto);
        }
        return result;
    }

    @Override
    public TablsDto save (TablsDto tablsDto) throws Exception {
        Tabls tabls = mapper.tablsDtoToTabls(tablsDto);
        Tabls savedTabls = tablsRepository.saveAndFlush(tabls);
        return mapper.tablsToTablsDto(savedTabls);
    }
    @Override
    public TablsDto update (TablsDto tablsDto) throws Exception {
        Tabls tabls = mapper.tablsDtoToTabls(tablsDto);
        Tabls updatedTabls = tablsRepository.saveAndFlush(tabls);
        return mapper.tablsToTablsDto(updatedTabls);
    }

    @Override
    public void deleteById ( int id) throws Exception {
        tablsRepository.deleteById(id);
    }

    @Override
    public TablsDto getById ( int id) throws Exception {
        Optional<Tabls> optional= tablsRepository.findById(id);
        if(optional.isPresent()){
            Tabls tabls = optional.get();
            return mapper.tablsToTablsDto(tabls);
        }

        return null;
    }
}
