package fr.eli.lebar.repository;

import fr.eli.lebar.entitie.Cocktail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocktailRepository extends JpaRepository<Cocktail, Integer> {

    Page<Cocktail> findAllByNameContaining(String name, Pageable pageable);

}