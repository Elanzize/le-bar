package fr.eli.lebar.repository;

import fr.eli.lebar.entitie.Boisson;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoissonRepository extends JpaRepository<Boisson, Integer> {

    //recherche toutes les boissons dont le nom contient une certaine chaîne, et renvoie une page de résultats, en fonction des paramètres de pagination spécifiés
    Page<Boisson> findAllByNameContaining(String name, Pageable pageable);

}
