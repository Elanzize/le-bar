package fr.eli.lebar.service;

import fr.eli.lebar.dtos.EmployeDto;
import fr.eli.lebar.entitie.Employe;
import fr.eli.lebar.mapper.EmployeMapper;
import fr.eli.lebar.repository.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class EmployeService implements IEmployeService {

    @Autowired
    private EmployeRepository employeRepository;
    private final EmployeMapper mapper = EmployeMapper.INSTANCE;
    @Override
    public List<EmployeDto> getAll() {
        List<Employe> employes = employeRepository.findAll();
        List<EmployeDto> employeDtos = new ArrayList<>();
        for (Employe Employe : employes) {
            EmployeDto employeDto = mapper.employeToEmployeDto(Employe);
            employeDtos.add(employeDto);
        }
        return employeDtos;
    }

    @Override
    public List<EmployeDto> getAllBy(int page, int size, String search) throws Exception {
        List<EmployeDto> result = new ArrayList<>();
        List<Employe> employes = employeRepository.findAllByNomContaining(search, PageRequest.of(page, size)).getContent();
        for (Employe e : employes) {
            EmployeDto employeDto = mapper.employeToEmployeDto(e);
            result.add(employeDto);
        }
        return result;
    }

    @Override
    public EmployeDto save (EmployeDto employeDto) throws Exception {
        Employe employe = mapper.employeDtoToEmploye(employeDto);
        Employe savedEmploye = employeRepository.saveAndFlush(employe);
        return mapper.employeToEmployeDto(savedEmploye);
    }
    @Override
    public EmployeDto update (EmployeDto employeDto) throws Exception {
        Employe employe = mapper.employeDtoToEmploye(employeDto);
        Employe updatedEmploye = employeRepository.saveAndFlush(employe);
        return mapper.employeToEmployeDto(updatedEmploye);
    }

    @Override
    public void deleteById ( int id) throws Exception {
        employeRepository.deleteById(id);
    }

    @Override
    public EmployeDto getById ( int id) throws Exception {
        Optional<Employe> optional= employeRepository.findById(id);
        if(optional.isPresent()){
            Employe employe = optional.get();
            return mapper.employeToEmployeDto(employe);
        }

        return null;
    }

}
