package fr.eli.lebar.entitie;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private  int numero;
    private String nom;
    private String prenom;
    private String telephone;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateReservation;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employe_id")
    private Employe employe;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tabls_id")
    private Tabls tabls;

}
