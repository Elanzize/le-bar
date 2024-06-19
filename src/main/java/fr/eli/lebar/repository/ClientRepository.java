package fr.eli.lebar.repository;


import fr.eli.lebar.entitie.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    Page<Client> findAllByNomContaining(String nom, Pageable pageable);

}
