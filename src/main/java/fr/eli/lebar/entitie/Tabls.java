package fr.eli.lebar.entitie;

import fr.eli.lebar.enums.Disponible;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tabls {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int numero;
    private int places;
    @Enumerated(EnumType.STRING)
    private Disponible disponible;

    @OneToOne(mappedBy = "tabls", fetch = FetchType.LAZY )
    private Reservation reservation;
    @OneToOne(mappedBy = "tabls", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
    private Commande commande;

}
