package fr.eli.lebar.repository;

import fr.eli.lebar.entitie.Employe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {
    Page<Employe> findAllByNomContaining(String nom, Pageable pageable);
}
