package fr.eli.lebar.entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int numero;
    private Date dateCommande;
    private double total;
    @ManyToOne
    @JoinColumn(name = "employe_id")
    private Employe employe;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "commande_boisson",
            joinColumns = @JoinColumn(name = "commande_id"),
            inverseJoinColumns = @JoinColumn(name = "boisson_id")
    )
    private Set<Boisson> boissons = new HashSet<>();
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tabls_id" )
    private Tabls tabls;


}
