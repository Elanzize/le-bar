package fr.eli.lebar.repository;

import fr.eli.lebar.entitie.Tabls;
import fr.eli.lebar.enums.Disponible;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface TablsRepository extends JpaRepository<Tabls, Integer> {
    Page<Tabls> findAllByNumeroContaining(int numero, Pageable pageable);
    @Transactional
    @Modifying
    @Query("UPDATE Tabls t SET t.disponible = ?2 WHERE t.id = ?1")
    void updateDisponibleById(Long tablsId, Disponible disponible);

}
