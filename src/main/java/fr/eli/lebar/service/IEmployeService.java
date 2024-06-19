package fr.eli.lebar.service;

import fr.eli.lebar.dtos.EmployeDto;

import java.util.List;

public interface IEmployeService {
    List<EmployeDto> getAll();
    List<EmployeDto> getAllBy(int page, int size, String search) throws Exception;
    EmployeDto save(EmployeDto employeDto) throws Exception;
    EmployeDto update(EmployeDto employeDto) throws Exception;
    void deleteById(int id) throws Exception;
    EmployeDto getById(int id) throws Exception;
}
