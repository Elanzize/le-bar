package fr.eli.lebar.repository;


import fr.eli.lebar.entitie.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {
}
