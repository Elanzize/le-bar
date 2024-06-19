package fr.eli.lebar.entitie;

import fr.eli.lebar.enums.Statut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private LocalDate dateNaissance;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telephone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Statut statut;
    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Commande> commandes;

    @OneToMany(mappedBy = "employe", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservations;



}
